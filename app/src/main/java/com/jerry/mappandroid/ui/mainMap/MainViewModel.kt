package com.jerry.mappandroid.ui.mainMap

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jerry.mappandroid.di.ActivityScope
import com.jerry.mappandroid.ui.MappLocationClient
import net.daum.mf.map.api.MapPoint
import javax.inject.Inject

/**
 * Created by jerry on 2021/03/20
 **/
@ActivityScope
class MainViewModel @Inject constructor(mappLocationClient: MappLocationClient): ViewModel() {
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