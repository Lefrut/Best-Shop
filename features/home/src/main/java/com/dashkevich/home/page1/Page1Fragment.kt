package com.dashkevich.home.page1

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.dashkevich.home.R
import com.dashkevich.home.databinding.FragmentPage1Binding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class Page1Fragment : Fragment(R.layout.fragment_page1) {

    lateinit var binding: FragmentPage1Binding
    private val page1ViewModel: Page1ViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPage1Binding.bind(view)


        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                page1ViewModel.uiState.collect { state ->
                    state.apply {

                    }
                }
            }
        }

        page1ViewModel.getData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    companion object{
        const val TAG = "Page1Fragment"
    }

}