package com.dashkevich.entry.register

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.dashkevich.entry.R
import com.dashkevich.entry.databinding.FragmentLoginBinding
import com.dashkevich.entry.databinding.FragmentRegisterBinding
import com.dashkevich.utility.isValidEmail

class RegisterFragment : Fragment(R.layout.fragment_register) {

    lateinit var binding: FragmentRegisterBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegisterBinding.bind(view)

        binding.signInButton.setOnClickListener {
            if (isValidEmail(binding.email.text.toString())) {
                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            } else {
                Toast.makeText(requireActivity(), "Не правильно введен email", Toast.LENGTH_SHORT).show()
            }
        }
    }
}