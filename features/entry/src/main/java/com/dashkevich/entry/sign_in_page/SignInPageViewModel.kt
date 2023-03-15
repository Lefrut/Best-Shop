package com.dashkevich.entry.sign_in_page

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dashkevich.dat.room.entity.User
import com.dashkevich.domain.repository.LocalDBRepository
import com.dashkevich.entry.sign_in_page.model.HaveUser
import com.dashkevich.entry.sign_in_page.model.SignInPageState
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch


class SignInPageViewModel(private val localDBRepository: LocalDBRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(SignInPageState())
    val uiState = _uiState.asStateFlow()

    suspend fun addUser(vararg users: User): Boolean {
        Log.e(TAG, "addUser: running")
        var result = false
        val job = viewModelScope.launch {
            localDBRepository.addUser(*users).onSuccess {
                result = it
            }.onFailure {
                Log.e(TAG, "addUser: ${it.message}")
            }
        }
        job.join()
        return result
    }

    fun haveUser(email: String) {
        viewModelScope.launch {
              localDBRepository.haveEmail(email).onEach {
                  val empty = it.isNullOrEmpty()
                  if (!empty) {
                      _uiState.value = _uiState.value.copy(haveUser = HaveUser.Yes)
                  } else {
                      _uiState.value = _uiState.value.copy(haveUser = HaveUser.No)
                  }
              }.catch {
                  Log.e(TAG, "haveUser: ${it.message}")
              }.collect()
        }
    }

    fun clearHaveUser() {
        _uiState.value = _uiState.value.copy(haveUser = HaveUser.Clear)
    }

    companion object {
        const val TAG = "Debug"
    }

}