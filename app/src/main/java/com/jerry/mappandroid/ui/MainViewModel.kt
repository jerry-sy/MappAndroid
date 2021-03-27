package com.jerry.mappandroid.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import net.daum.mf.map.api.MapPoint

/**
 * Created by jerry on 2021/03/20
 **/
class MainViewModel : ViewModel(){
    private val _currentMapPoint = MutableLiveData<MapPoint>()
    val currentMapPoint : LiveData<MapPoint>
    get() = _currentMapPoint

    fun onClickCurrentLocation(){
        // TODO check permission of LOCATION
        getCurrentLocationMapPoint()
    }

    private fun getCurrentLocationMapPoint() : MapPoint {
        //TODO get current location
        return MapPoint.mapPointWithGeoCoord(0.0,0.0)
    }


}