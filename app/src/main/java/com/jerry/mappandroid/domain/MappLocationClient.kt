package com.jerry.mappandroid.domain

import net.daum.mf.map.api.MapPoint

/**
 * Created by jerry on 2021/04/24
 **/
interface MappLocationClient {
    suspend fun getCurrentLocation() : MapPoint?
    fun getLastLocation()
    fun updateCurrentLocation()
}