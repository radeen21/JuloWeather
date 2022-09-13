package com.example.feature_addcity.presentation

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.base.LocationService
import com.example.base.viewmodel.BaseViewModel
import com.example.domain.entities.forecast.ForecastEntities
import com.example.domain.interactor.ForecastUseCase
import com.example.domain.subcriber.DefaultSubscriber
import com.example.domain.subcriber.ResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(
    private var forecastUseCase: ForecastUseCase,
) : BaseViewModel() {

    lateinit var locationService: LocationService

    private val _getForecast = MutableLiveData<ResultState<ForecastEntities>>()
    val getForecastLiveData: LiveData<ResultState<ForecastEntities>> =
        _getForecast

    fun fetchForecast(cityName: String, appId: String) {
        forecastUseCase.execute(
            object : DefaultSubscriber<ForecastEntities>() {
                override fun onError(error: ResultState<ForecastEntities>) {
                    val message: String? = (error as ResultState.Error).throwable.message
                    Log.d(ContentValues.TAG, "Error : $message")
                    _getForecast.value = error
                }

                override fun onSuccess(data: ResultState<ForecastEntities>) {
                    val dataResultWeather = (data as ResultState.Success).data
                    Log.d(ContentValues.TAG, "Success Fetched : $dataResultWeather")
                    _getForecast.value = data
                }

            }, ForecastUseCase.Params(cityName, appId)
        )
    }

}