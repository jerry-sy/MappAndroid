package com.jerry.mappandroid.domain

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.os.Looper
import android.util.Log
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.jerry.mappandroid.di.ActivityScope
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import net.daum.mf.map.api.MapPoint
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Scope
import javax.inject.Singleton

/**
 * Created by jerry on 2021/03/29
 **/
@ActivityScope
class MappLocationClientImpl @Inject constructor(private val context: Context ): MappLocationClient{
    private val clientInstance = FusedLocationProviderClient(context)

    private suspend fun getCurrentLocationImpl(): MapPoint? {
        return try {
            updateCurrentLocationImpl()
        } catch (e: Exception){
            // permission Not granted
            null
        }
    }

    @Throws(Exception::class)
    private suspend fun updateCurrentLocationImpl(): MapPoint{
        val deferred: CompletableDeferred<Location> = CompletableDeferred()
        withContext(Dispatchers.IO){
            if (ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                Log.d("JerryTag","permission not granted")
                throw Exception()
            }

            val locationCallback = object : LocationCallback(){
                override fun onLocationResult(result: LocationResult) {
                    super.onLocationResult(result)
                    // check locations data list
                    // @result.locations
                    deferred.complete(result.lastLocation)
                }
            }

            clientInstance.requestLocationUpdates(
                LocationRequest.create().apply {
                    interval = 10000
                    fastestInterval = 5000
                    priority = LocationRequest.PRIORITY_HIGH_ACCURACY
                },
                locationCallback,
                Looper.getMainLooper())
        }
        return deferred.await().toMapPoint()
    }

    private fun Location.toMapPoint(): MapPoint{
        return MapPoint.mapPointWithGeoCoord(this.latitude, this.longitude)
    }

    override fun getLastLocation() {
        TODO("Not yet implemented")
    }

    override suspend fun getCurrentLocation(): MapPoint? {
        return getCurrentLocationImpl()
    }

    override fun updateCurrentLocation() {
        TODO("Not yet implemented")
    }
}