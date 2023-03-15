package com.dashkevich.entry.login

import android.os.Bundle
import android.text.InputType
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.dashkevich.entry.R
import com.dashkevich.entry.databinding.FragmentLoginBinding
import com.dashkevich.entry.sign_in_page.model.HaveUser
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding
    private val loginViewModel: LoginViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)


        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                loginViewModel.uiState.collect { loginState ->
                    when (loginState.loginUser) {
                        HaveUser.Clear -> {}
                        HaveUser.Yes -> {
                            findNavController().navigate(com.dashkevich.navigation.R.id.action_global_bottom)
                        }
                        HaveUser.No -> {
                            Toast.makeText(
                                requireContext(),
                                "Нет такого пользователя",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                    loginViewModel.clearLoginUser()
                }
            }
        }

        binding.visibilityPassword.setOnClickListener {
            val password = binding.password
            password.inputType =
                if (password.inputType == InputType.TYPE_CLASS_TEXT) {
                    password.transformationMethod = PasswordTransformationMethod()
                    InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                } else {
                    password.transformationMethod = HideReturnsTransformationMethod()
                    InputType.TYPE_CLASS_TEXT
                }
            password.setSelection(password.length())
        }

        binding.loginButton.setOnClickListener {
            loginViewModel.getUser(
                binding.firstNameL.text.toString(),
                binding.password.text.toString()
            )
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.password.setText("")
        binding.firstNameL.setText("")
    }
}