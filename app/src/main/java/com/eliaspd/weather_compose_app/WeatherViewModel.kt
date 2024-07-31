package com.eliaspd.weather_compose_app

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eliaspd.weather_compose_app.api.Constant
import com.eliaspd.weather_compose_app.api.RetrofitInstance
import kotlinx.coroutines.launch

class WeatherViewModel: ViewModel() {

    private val weatherApi = RetrofitInstance.weatherApi
    fun getData(city : String) {

        viewModelScope.launch {
            val response = weatherApi.getWeather(Constant.apiKey,city)
            if (response.isSuccesful) {

            } else {
                 
            }
        }


    }
}