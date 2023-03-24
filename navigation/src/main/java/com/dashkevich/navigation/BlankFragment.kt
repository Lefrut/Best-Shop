package com.dashkevich.navigation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class BlankFragment: Fragment(R.layout.fragment_blank) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("Navigation", "LoginFragment, onViewCreated: create", )
        Log.e("Navigation", "LoginFragment, onViewCreated: bug fix", )
        findNavController().navigate(R.id.action_global_login_nav_graph)
    }

}