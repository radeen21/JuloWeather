package com.example.prodiatest

import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.example.base.presentation.BaseActivity
import com.example.prodiatest.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    private lateinit var navHostFragment: NavHostFragment

    override val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override val viewModel: MainViewModel by viewModels()

    override fun onInitViews() {
        supportActionBar?.hide()

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.homeFragment) as NavHostFragment
        val navController = navHostFragment.navController

        navigator.navController = navController
    }

    override fun onInitObservers() = Unit
}