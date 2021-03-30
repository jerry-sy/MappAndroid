package com.jerry.mappandroid.ui

import android.content.Context
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationResult
import com.jerry.mappandroid.di.ActivityScope
import kotlinx.coroutines.CompletableDeferred
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by jerry on 2021/03/29
 **/
@ActivityScope
class MappLocationClient @Inject constructor(val context: Context){
    private val clientInstance = FusedLocationProviderClient(context)

    fun getCurrentLocation(deferred: CompletableDeferred<LocationResult>){
    }

    fun getLastLocation (){

    }

    fun updateCurrentLocation(){

    }
}