package com.jerry.mappandroid.ui.mainMap

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.jerry.mappandroid.MappApplication
import com.jerry.mappandroid.R
import com.jerry.mappandroid.databinding.ActivityMainBinding
import net.daum.mf.map.api.MapView
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    @Inject
    lateinit var mainViewModel : MainViewModel

    private lateinit var mapView : MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mapView = MapView(this)
        binding.mainMapView.addView(mapView)

        (applicationContext as MappApplication).appComponent.locationComponent().create(this).inject(this)

        mainViewModel.currentMapPoint.observe(this, { mapPoint ->
            mapView.setMapCenterPoint(mapPoint, true)
        })
    }

}