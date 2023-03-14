package com.dashkevich.entry.sign_in_page

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.dashkevich.dat.room.entity.User
import com.dashkevich.entry.R
import com.dashkevich.entry.databinding.FragmentSignInPageBinding
import com.dashkevich.utility.adapter.BaseAdapterDelegate
import com.dashkevich.entry.sign_in_page.adapter.model.CompanySignIn
import com.dashkevich.entry.sign_in_page.adapter.model.CompanySignInDelegate
import com.dashkevich.entry.sign_in_page.model.HaveUser
import com.dashkevich.utility.isValidEmail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignInPageFragment : Fragment(R.layout.fragment_sign_in_page) {

    private lateinit var binding: FragmentSignInPageBinding
    private val signInPageViewModel: SignInPageViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignInPageBinding.bind(view)

        requireActivity().window.navigationBarColor = resources.getColor(com.dashkevich.ui.R.color.main_screen)
        val firstName = binding.firstName
        val lastName = binding.lastName
        val email = binding.email

        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                signInPageViewModel.uiState.collect { state ->
                    state.apply {
                        when (haveUser) {
                            HaveUser.Yes -> {
                                Toast.makeText(
                                    requireActivity(),
                                    "Пользователь с таким email существует",
                                    Toast.LENGTH_SHORT
                                ).show()
                                signInPageViewModel.clearHaveUser()
                            }
                            HaveUser.No -> {
                                val result = signInPageViewModel.addUser(
                                    User(
                                        id = 0,
                                        firstName = firstName.text.toString(),
                                        lastName = lastName.text.toString(),
                                        email = email.text.toString(),
                                        password = email.text.toString()
                                    )
                                )
                                if (result) findNavController().navigate(R.id.action_signInPageFragment_to_loginFragment)
                                else Toast.makeText(
                                    requireActivity(),
                                    "Не удалось создать пользователя",
                                    Toast.LENGTH_SHORT
                                ).show()
                                signInPageViewModel.clearHaveUser()
                            }
                            HaveUser.Clear -> {}
                        }
                    }
                }
            }
        }

        binding.signInButton.setOnClickListener {
            signInButtonClick(
                binding.firstName.text.toString(),
                binding.lastName.text.toString(),
                binding.email.text.toString()
            )
        }

        binding.log.setOnClickListener {
            findNavController().navigate(R.id.action_signInPageFragment_to_loginFragment)
        }

        val adapter = BaseAdapterDelegate(
            listOf(
                CompanySignInDelegate(onClick = { findNavController().navigate(com.dashkevich.navigation.R.id.action_global_bottom) })
            )
        )
        binding.listView.adapter = adapter
        adapter.setItems(
            listOf(
                CompanySignIn(
                    icon = com.dashkevich.ui.R.drawable.google,
                    iconMarginEnd = 11,
                    text = com.dashkevich.ui.R.string.sign_in_with_google
                ),
                CompanySignIn(
                    icon = com.dashkevich.ui.R.drawable.apple,
                    iconMarginEnd = 13,
                    text = com.dashkevich.ui.R.string.sign_in_with_apple
                )
            )
        )

    }

    override fun onDestroyView() {
        super.onDestroyView()
        clearBinding()
    }

    private fun signInButtonClick(firstName: String, lastName: String, email: String) {
        if (isValidEmail(email)) {
            if (firstName.isNotEmpty() && lastName.isNotEmpty())
                signInPageViewModel.haveUser(email)
            else
                Toast.makeText(
                    requireActivity(),
                    "Пустое поле имени или фамилии",
                    Toast.LENGTH_SHORT
                ).show()
        } else {
            Toast.makeText(requireActivity(), "Не правильно введен email", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun clearBinding() {
        binding.apply {
            email.setText("")
            lastName.setText("")
            firstName.setText("")
        }
    }
}