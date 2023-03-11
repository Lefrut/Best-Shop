package com.dashkevich.entry.login

import android.os.Bundle
import android.text.InputType
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dashkevich.entry.R
import com.dashkevich.entry.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)


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
    }
}