package com.jerry.mappandroid

import android.app.Application
import com.jerry.mappandroid.di.component.AppComponent
import com.jerry.mappandroid.di.component.DaggerAppComponent
import com.jerry.mappandroid.di.modules.AppModule

/**
 * Created by jerry on 2021/03/28
 **/
class MappApplication : Application() {
    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}