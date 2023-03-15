package com.dashkevich.home.page1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dashkevich.home.R
import com.dashkevich.home.databinding.FragmentPage1Binding
import com.dashkevich.home.page1.adapter.Adapter
import com.dashkevich.home.page1.adapter.delegates.CategoryDelegate
import com.dashkevich.home.page1.adapter.delegates.FlashSaleDelegate
import com.dashkevich.home.page1.adapter.delegates.LatestDelegate
import com.dashkevich.home.page1.adapter.delegates.TitleDelegate
import com.dashkevich.home.page1.adapter.model.Category
import com.dashkevich.home.page1.adapter.model.FlashSaleUI
import com.dashkevich.home.page1.adapter.model.LatestUI
import com.dashkevich.home.page1.adapter.model.Title
import com.dashkevich.home.page1.model.ScreenStatus
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class Page1Fragment : Fragment(R.layout.fragment_page1) {

    private lateinit var binding: FragmentPage1Binding
    private val page1ViewModel: Page1ViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPage1Binding.bind(view)


        val adapter = Adapter(
            listOf(
                TitleDelegate(),
                LatestDelegate(),
                FlashSaleDelegate(),
                CategoryDelegate()
            )
        )
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter.setItems(
            listOf(
                Category(com.dashkevich.ui.R.drawable.phone_category, "Phone"),
                Title(text = "Latest", margin = 29),
                LatestUI(category = "phone", title = "Samsung", price = 100, ""),
                Title(text = "Flash Sale"),
                FlashSaleUI(
                    category = "phone",
                    title = "Samsung",
                    price = 100,
                    discount = 30,
                    image = ""
                ),
                Title(text = "Brands")
            )
        )

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                page1ViewModel.uiState.collect { state ->
                    state.apply {
                        when (screenStatus) {
                            ScreenStatus.Success -> {

                            }
                            ScreenStatus.Error -> {

                            }

                            ScreenStatus.Loading -> {

                            }
                            ScreenStatus.EmptyResult -> {

                            }
                        }
                    }
                }
            }
        }

        page1ViewModel.getData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    companion object {
        const val TAG = "Page1Fragment"
    }

}