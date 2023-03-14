package com.dashkevich.profile

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import com.dashkevich.navigation.findRootNavController
import com.dashkevich.profile.databinding.FragmentProfileBinding
import com.dashkevich.profile.model.ProfileItem
import com.dashkevich.profile.model.ProfileItemDelegate
import com.dashkevich.utility.adapter.BaseAdapterDelegate

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private lateinit var binding: FragmentProfileBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)

        val adapter = BaseAdapterDelegate(listOf(ProfileItemDelegate()))
        binding.listView.adapter = adapter
        adapter.setItems(ProfileItem.baseItems + ProfileItem(
            icon = com.dashkevich.ui.R.drawable.exit,
            text = com.dashkevich.ui.R.string.log_out,
            marginEnd = 45,
            onClick = {
                findRootNavController().navigate(com.dashkevich.navigation.R.id.action_global_login_nav_graph)
            }
        ))

    }

}