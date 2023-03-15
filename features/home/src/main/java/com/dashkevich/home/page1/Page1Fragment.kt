package com.dashkevich.home.page1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dashkevich.dat.api.model.FlashSaleItem
import com.dashkevich.dat.api.model.LatestItem
import com.dashkevich.home.R
import com.dashkevich.home.databinding.FragmentPage1Binding
import com.dashkevich.home.page1.adapter.Adapter
import com.dashkevich.home.page1.adapter.delegates.*
import com.dashkevich.home.page1.adapter.model.*
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
                HorizontalItemsDelegate(
                    listOf(
                        LatestDelegate(),
                        FlashSaleDelegate(),
                        CategoryDelegate(),
                    )
                )
            )
        )
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter.setItems(
            listOf(
                HorizontalItems(
                    Category.list
                ),
            )
        )

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                page1ViewModel.uiState.collect { state ->
                    state.apply {
                        when (screenStatus) {
                            ScreenStatus.Success -> {
                                adapter.setItems(
                                    listOf(
                                        HorizontalItems(
                                            Category.list
                                        ),
                                        Title(text = "Latest", margin = 29),
                                        HorizontalItems(
                                            latest.latest.toLatestUI()
                                        ),
                                        Title(text = "Flash Sale"),
                                        HorizontalItems(
                                            flashSale.flashSale.toFlashSaleUI()
                                        ),
                                        Title(text = "Brands")
                                    )
                                )
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

    fun List<LatestItem>.toLatestUI(): List<LatestUI>{
        return map{
            LatestUI(
                category = it.category,
                title = it.name,
                image = it.image_url,
                price = it.price
            )
        }
    }

    fun List<FlashSaleItem>.toFlashSaleUI(): List<FlashSaleUI>{
        return map{
            FlashSaleUI(
                category = it.category,
                title = it.name,
                image = it.image_url,
                price = it.price,
                discount = it.discount
            )
        }
    }

}