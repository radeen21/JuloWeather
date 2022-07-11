package com.example.base.navigation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.base.databinding.FragmentStartBinding
import com.example.base.presentation.BaseFragment
import com.example.base.viewmodel.BaseViewModel
import com.example.navigation.NavigationFlow
import com.example.navigation.ToFlowNavigatable

class StartFragment : BaseFragment<FragmentStartBinding, BaseViewModel>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setSelectedTab(0)
    }

    private fun setSelectedTab(selectedTab: Int) {
        when (selectedTab) {
            0 -> (requireActivity() as ToFlowNavigatable).navigateToFlow(NavigationFlow.HomeFlow("This Splash Page"))
//            1 -> (requireActivity() as ToFlowNavigatable).navigateToFlow(NavigationFlow.AuthFlow("This Auth Page"))
//            2 -> (requireActivity() as ToFlowNavigatable).navigateToFlow(NavigationFlow.HomeFlow("This Home Page"))
//            3 -> (requireActivity() as ToFlowNavigatable).navigateToFlow(NavigationFlow.BerandaToTopUpFlow("This Home Page to TopUp Page"))
//            4 -> (requireActivity() as ToFlowNavigatable).navigateToFlow(NavigationFlow.BerandaToTransaksiPulsaFlow("This Home Page to Transaction Page"))
//            5 -> (requireActivity() as ToFlowNavigatable).navigateToFlow(NavigationFlow.VerificationFlow("This Home Page to Transaction Page"))
        }
    }

    override val viewModel: BaseViewModel by viewModels()
    override val binding: FragmentStartBinding by lazy {
        FragmentStartBinding.inflate(layoutInflater)
    }
}