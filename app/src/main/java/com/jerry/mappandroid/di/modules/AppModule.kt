package com.jerry.mappandroid.di.modules

import android.content.Context
import com.jerry.mappandroid.domain.MappLocationClient
import com.jerry.mappandroid.domain.MappLocationClientImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by jerry on 2021/04/24
 **/
@Module
class AppModule constructor(private val context: Context){

    @Singleton
    @Provides
    fun getContext() = context

    @Singleton
    @Provides
    fun getMappLocationClient(): MappLocationClient = MappLocationClientImpl(getContext())
}