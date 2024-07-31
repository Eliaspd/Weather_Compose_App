 package com.eliaspd.weather_compose_app

 import android.util.Log
 import androidx.lifecycle.LiveData
 import androidx.lifecycle.MutableLiveData
 import androidx.lifecycle.ViewModel
 import androidx.lifecycle.viewModelScope
 import com.eliaspd.weather_compose_app.api.Constant
 import com.eliaspd.weather_compose_app.api.NetworkResponse
 import com.eliaspd.weather_compose_app.api.RetrofitInstance
 import com.eliaspd.weather_compose_app.api.WeatherModel
 import kotlinx.coroutines.launch

 class WeatherViewModel: ViewModel() {

     private val weatherApi = RetrofitInstance.weatherApi
     private val _weatherResult = MutableLiveData<NetworkResponse<WeatherModel>>()
     val weatherResult: LiveData<NetworkResponse<WeatherModel>> = _weatherResult

     fun getData(city: String) {
         _weatherResult.value = NetworkResponse.Loading
         viewModelScope.launch {
             try {
                 val response = weatherApi.getWeather(Constant.apiKey, city)
                 if (response.isSuccessful) {
                     response.body()?.let { weatherModel: WeatherModel ->
                         _weatherResult.value = NetworkResponse.Success(weatherModel)
                     } ?: run {
                         _weatherResult.value = NetworkResponse.Error("Response body is null")
                     }
                 } else {
                     _weatherResult.value = NetworkResponse.Error("Failed to load data")
                 }
             } catch (e: Exception) {
                 _weatherResult.value = NetworkResponse.Error("Failed to load data")
             }
         }
     }
 }




