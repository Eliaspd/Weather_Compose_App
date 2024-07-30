package com.eliaspd.weather_compose_app

import android.util.Log
import androidx.lifecycle.ViewModel

class WeatherViewModel: ViewModel() {
    fun getData(city : String) {
        Log.i("City name: ", city)
    }
}