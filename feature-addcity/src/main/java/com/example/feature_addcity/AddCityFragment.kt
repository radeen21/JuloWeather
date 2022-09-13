package com.example.feature_addcity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.base.config.Constant
import com.example.base.date.DateUtils
import com.example.base.presentation.BaseFragment
import com.example.base.viewmodel.BaseViewModel
import com.example.domain.entities.forecast.ForecastEntities
import com.example.domain.subcriber.ResultState
import com.example.feature_addcity.databinding.FragmentAddCitiesBinding
import com.example.feature_addcity.presentation.ForecastViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.FragmentScoped
import kotlin.math.roundToInt

@FragmentScoped
@AndroidEntryPoint
class AddCityFragment : BaseFragment<FragmentAddCitiesBinding, BaseViewModel>() {

    @FragmentScoped
    override val viewModel: ForecastViewModel by viewModels()
    override val binding: FragmentAddCitiesBinding by lazy {
        FragmentAddCitiesBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getForecast()
    }

    override fun onInitObservers() {
        super.onInitObservers()
        viewModel.getForecastLiveData.observe(viewLifecycleOwner, Observer {
            onResultForecastLoaded(it)
        })
    }

    private fun onResultForecastLoaded(resultState: ResultState<ForecastEntities>) {
        when (resultState) {
            is ResultState.Success -> {
                binding.layoutContainer.visibility = View.VISIBLE
                val celsiusFromKelvin = resultState.data.main.temp?.minus(273.15)
                val celsiusValue = celsiusFromKelvin?.roundToInt()

                binding.viewLocaleDate.text        = resources.getString(R.string.date_today, resultState.data.dt.let { DateUtils.convertLongToTime(
                    it!!
                ) })
                binding.viewTextHumidityValue.text = resultState.data.main.humidity.toString()
                binding.viewTextWeatherDesc.text   = resultState.data.weather.get(0).description
                binding.viewTextWindValue.text     = (resultState.data.wind.speed?.times(3.6)).toString()

                binding.viewTextCelsius.text =
                    resources.getString(R.string.celsius_value, celsiusValue)

            }
            is ResultState.Error -> {
                Toast.makeText(
                    requireContext(),
                    resultState.throwable.localizedMessage,
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }
    }

    fun getForecast() {
        binding.btnSearch.setOnClickListener {
            val cityName = binding.viewEditTextCity.editText?.text.toString()
            viewModel.fetchForecast("jakarta", Constant.API_KEY)
        }
    }

}