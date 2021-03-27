package com.jerry.mappandroid.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.jerry.mappandroid.R
import com.jerry.mappandroid.databinding.ActivityMainBinding
import net.daum.mf.map.api.MapView


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private val mainViewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }

    private lateinit var mapView : MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mapView = MapView(this)
        binding.mainMapView.addView(mapView)
        mainViewModel.currentMapPoint.observe(this, { mapPoint ->
            mapView.setMapCenterPoint(mapPoint, true)
        })
    }

}