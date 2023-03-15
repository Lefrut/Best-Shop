package com.dashkevich.entry.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dashkevich.domain.repository.LocalDBRepository
import com.dashkevich.entry.login.model.LoginState
import com.dashkevich.entry.sign_in_page.SignInPageViewModel
import com.dashkevich.entry.sign_in_page.model.HaveUser
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class LoginViewModel(private val localDBRepository: LocalDBRepository): ViewModel() {

    private val _uiState = MutableStateFlow(LoginState())
    val uiState = _uiState.asStateFlow()

    fun getUser(firstName: String, password: String){
        viewModelScope.launch {
            localDBRepository.getUser(firstName, password).onEach { user ->
                if (user != null) {
                    _uiState.value = uiState.value.copy(loginUser = HaveUser.Yes, user = user)
                }else{
                    _uiState.value = uiState.value.copy(loginUser = HaveUser.No)
                }
            }.catch {
                Log.e(SignInPageViewModel.TAG, "haveUser: ${it.message}")
            }.collect()
        }
    }

    fun clearLoginUser(){
        _uiState.value = uiState.value.copy(loginUser = HaveUser.Clear)
    }

}