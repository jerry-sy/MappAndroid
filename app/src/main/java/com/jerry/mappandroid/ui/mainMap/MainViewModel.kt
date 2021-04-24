package com.jerry.mappandroid.ui.mainMap

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jerry.mappandroid.di.ActivityScope
import com.jerry.mappandroid.domain.MappLocationClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.daum.mf.map.api.MapPoint
import javax.inject.Inject

/**
 * Created by jerry on 2021/03/20
 **/
@ActivityScope
class MainViewModel @Inject constructor(private val mappLocationClient: MappLocationClient): ViewModel() {
    private val _currentMapPoint = MutableLiveData<MapPoint>().apply { value = MapPoint.mapPointWithGeoCoord(0.0,0.0) }
    val currentMapPoint : LiveData<MapPoint>
    get() = _currentMapPoint

    fun onClickCurrentLocation(){
        // TODO check permission of LOCATION and require permission
        viewModelScope.launch(Dispatchers.IO) {
            getCurrentLocationMapPoint()
        }
    }

    private suspend fun getCurrentLocationMapPoint(){
        val result = mappLocationClient.getCurrentLocation()
        //TODO get current location
        if (result == null){
            Log.d("JerryTag","result is null cause from permission granted")
            //TODO send view event
            return
        }
        _currentMapPoint.postValue(result)
    }


}