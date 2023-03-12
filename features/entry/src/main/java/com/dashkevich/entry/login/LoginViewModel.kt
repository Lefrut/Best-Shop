package com.dashkevich.entry.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dashkevich.dat.room.entity.User
import com.dashkevich.entry.sign_in_page.model.HaveUser
import com.dashkevich.entry.sign_in_page.model.SignInPageState
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(SignInPageState())
    val uiState = _uiState.asStateFlow()

}