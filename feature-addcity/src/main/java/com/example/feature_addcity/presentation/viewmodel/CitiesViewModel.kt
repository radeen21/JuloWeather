package com.example.feature_addcity.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.base.viewmodel.BaseViewModel
import com.example.domain.entities.forecast.ForecastDataEntities
import com.example.domain.repository.ForecastRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CitiesViewModel @Inject constructor(private val forecastRepository: ForecastRepository) :
    BaseViewModel() {

    private val _dataCities = MutableLiveData<List<ForecastDataEntities>>()
    val dataCities: LiveData<List<ForecastDataEntities>> get() = _dataCities

//    fun getSavedCities() {
//        viewModelScope.launch {
//            _dataCities.value = forecastRepository.getFavoriteCities()
//        }
//    }
//
//    fun removeFromFav(t: ForecastDataEntities) {
//        viewModelScope.launch {
//            forecastRepository.deleteFavoriteCity(t)
//        }
//    }

    init {
//        getSavedCities()
    }

}