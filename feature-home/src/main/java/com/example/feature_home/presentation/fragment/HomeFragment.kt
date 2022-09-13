package com.example.feature_home.presentation.fragment

import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.base.config.Constant
import com.example.base.date.DateUtils
import com.example.base.presentation.BaseFragment
import com.example.base.viewmodel.BaseViewModel
import com.example.domain.entities.DailyWeatherItemEntities
import com.example.domain.entities.WeatherEntities
import com.example.domain.subcriber.ResultState
import com.example.feature_home.R
import com.example.feature_home.databinding.FragmentHomeBinding
import com.example.feature_home.presentation.WeatherViewModel
import com.example.feature_home.presentation.adapter.HomeAdapter
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.FragmentScoped
import kotlin.math.roundToInt

@FragmentScoped
@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, BaseViewModel>() {

    lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    private lateinit var adapter: HomeAdapter
    private var layoutManager: RecyclerView.LayoutManager? = null

    @FragmentScoped
    override val viewModel: WeatherViewModel by viewModels()
    override val binding: FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(requireContext())
        nextPage()
        getWeather()

    }

    override fun onInitObservers() {
        super.onInitObservers()
        viewModel.getWeatherLiveData.observe(viewLifecycleOwner, Observer {
            onResultWeatherLoaded(it)
        })
    }

    private fun onResultWeatherLoaded(resultState: ResultState<WeatherEntities>) {
        when (resultState) {
            is ResultState.Success -> {
                val celsiusFromKelvin = resultState.data.current.temp.minus(273.15)
                val celsiusValue = celsiusFromKelvin.roundToInt()


                Glide.with(requireContext()).load(
                    "${"https://openweathermap.org/img/w"}/${
                        resultState.data.current?.weather.get(0).icon
                    }.png"
                ).into(binding.ivWeather)
                binding.tvCity.text = resultState.data.timezone
                binding.tvTemp.text = resources.getString(R.string.celsius_value, celsiusValue)
                binding.tvDay.text = resources.getString(
                    R.string.date_today,
                    resultState.data.current.dt.let { DateUtils.convertLongToTime(it!!) })

                for (item in resultState.data.current.weather) {
                    binding.tvDescWeather.text = item.description
                }
                initAdapter(resultState.data.daily)
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

    fun getWeather() {
        val task = fusedLocationProviderClient.lastLocation

        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION
            )
            != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireContext(),
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            )
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 101
            )
            return
        }

        task.addOnSuccessListener {
            if (it != null) {
                viewModel.fetchWeather(
                    it.latitude.toString(),
                    it.longitude.toString(),
                    "Minutely, Hourly",
                    Constant.API_KEY
                )

                binding.tvLat.text = it.latitude.toString() + " S"
                binding.tvLong.text = it.longitude.toString() + " E"

            }
        }
    }

    private fun initAdapter(resultState: List<DailyWeatherItemEntities>?) {
        adapter = HomeAdapter(resultState)
        layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recHome.layoutManager = layoutManager
        binding.recHome.adapter = adapter
    }

    fun nextPage() {
        binding.tvAddCity.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_add_city)
        }
    }
}