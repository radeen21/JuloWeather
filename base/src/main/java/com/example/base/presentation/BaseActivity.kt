package com.example.base.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.example.navigation.NavigationFlow
import com.example.navigation.Navigator
import com.example.navigation.ToFlowNavigatable
import javax.inject.Inject

@SuppressLint("Registered")
abstract class BaseActivity<VB : ViewBinding, VM : ViewModel> : AppCompatActivity(),
    ToFlowNavigatable {

    abstract val binding: VB
    abstract val viewModel: VM


    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        onInitViews()
        onInitObservers()
    }

    abstract fun onInitViews()

    abstract fun onInitObservers()


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun navigateToFlow(flow: NavigationFlow) {
        navigator.navigateToFlow(flow)
    }
}