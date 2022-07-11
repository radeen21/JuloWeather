package com.example.feature_home.presentation

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.base.LocationService
import com.example.base.viewmodel.BaseViewModel
import com.example.domain.entities.WeatherEntities
import com.example.domain.interactor.WeatherUseCase
import com.example.domain.subcriber.DefaultSubscriber
import com.example.domain.subcriber.ResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private var weatherUseCase: WeatherUseCase,
) : BaseViewModel() {

    lateinit var locationService: LocationService


    private val _getWeather = MutableLiveData<ResultState<WeatherEntities>>()
    val getWeatherLiveData: LiveData<ResultState<WeatherEntities>> =
        _getWeather

    fun fetchWeather(lat: String, lon: String, exclude: String, apikey: String) {
        weatherUseCase.execute(
            object : DefaultSubscriber<WeatherEntities>() {
                override fun onError(error: ResultState<WeatherEntities>) {
                    val message: String? = (error as ResultState.Error).throwable.message
                    Log.d(ContentValues.TAG, "Error : $message")
                    _getWeather.value = error
                }

                override fun onSuccess(data: ResultState<WeatherEntities>) {
                    val dataResultWeather = (data as ResultState.Success).data
                    Log.d(ContentValues.TAG, "Success Fetched : $dataResultWeather")
                    _getWeather.value = data
                }

            }, WeatherUseCase.Params(lat, lon, exclude, apikey)
        )
    }

}