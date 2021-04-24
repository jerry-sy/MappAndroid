package com.jerry.mappandroid.di.component

import com.jerry.mappandroid.di.ActivityScope
import com.jerry.mappandroid.di.modules.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by jerry on 2021/03/28
 **/
@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    @ActivityScope
    fun locationComponent() : LocationComponent.Factory
}