package com.dashkevich.home.page1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dashkevich.domain.repository.ProductRepository
import com.dashkevich.home.page1.model.Page1State
import com.dashkevich.home.page1.model.ScreenStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class Page1ViewModel(private val productRepository: ProductRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(Page1State())
    private val uiState = _uiState.asStateFlow()

    fun getData() {
        viewModelScope.launch {
            productRepository.getData(this).onSuccess { data ->
                if (data.first.latest.isNotEmpty() || data.second.flashSale.isNotEmpty()) {
                    _uiState.value = uiState.value.copy(
                        screenStatus = ScreenStatus.Success,
                        latest = data.first,
                        flashSale = data.second
                    )
                } else {
                    _uiState.value = uiState.value.copy(
                        screenStatus = ScreenStatus.EmptyResult
                    )
                    if (data.first.latest.isNotEmpty()) {
                        _uiState.value = uiState.value.copy(latest = data.first)
                    } else if (data.second.flashSale.isNotEmpty()) {
                        _uiState.value = uiState.value.copy(flashSale = data.second)
                    }
                }

            }.onFailure {
                _uiState.value = uiState.value.copy(screenStatus = ScreenStatus.Error)
            }
        }
    }
}