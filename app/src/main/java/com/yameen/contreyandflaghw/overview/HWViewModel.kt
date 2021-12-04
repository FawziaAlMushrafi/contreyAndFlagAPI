package com.yameen.contreyandflaghw.overview


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yameen.contreyandflaghw.internet.ser
import kotlinx.coroutines.launch


class HWViewModel :ViewModel(){
    private var _numberOfCountry =MutableLiveData<String>()
    val numberOfCountry :LiveData<String> = _numberOfCountry
    init {
        getNumberOfCountry()
    }

    private fun getNumberOfCountry() {
        viewModelScope.launch {
            try {
                var result=ser.retrofitService.getCountry()

                _numberOfCountry.value =result.data.size.toString()
                Log.e("TAG", "getNumberOfCountry: ${    _numberOfCountry.value}", )
            }catch (e:Exception){
                _numberOfCountry.value="Failure: 1 ${e.message}"
            }
        }
    }
}