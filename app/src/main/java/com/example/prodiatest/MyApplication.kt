package com.example.prodiatest

import com.example.base.presentation.BaseApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : BaseApplication() {
    override fun getBaseUrl(): String =
        BuildConfig.API_BASE_URL
}