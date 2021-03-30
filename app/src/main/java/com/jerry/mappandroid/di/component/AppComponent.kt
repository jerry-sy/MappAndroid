package com.jerry.mappandroid.di.component

import com.jerry.mappandroid.di.ActivityScope
import dagger.Component
import javax.inject.Singleton

/**
 * Created by jerry on 2021/03/28
 **/
@Singleton
@Component
interface AppComponent {
    @ActivityScope
    fun locationComponent() : LocationComponent.Factory
}