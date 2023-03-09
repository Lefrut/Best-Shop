package com.dashkevich.home.page1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dashkevich.domain.repository.ProductRepository
import com.dashkevich.home.page1.model.Page1State
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class Page1ViewModel(private val productRepository: ProductRepository) : ViewModel() {

    private val state = MutableStateFlow(Page1State())
    private val _state = state.asStateFlow()

    fun getLatest() {
        viewModelScope.launch {
            productRepository.getLatest().onSuccess {

            }.onFailure {

            }
        }
    }

    fun getFlashSale() {

    }

}