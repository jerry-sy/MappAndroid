package com.jerry.mappandroid.di.component

import android.content.Context
import com.jerry.mappandroid.di.ActivityScope
import com.jerry.mappandroid.ui.mainMap.MainActivity
import dagger.BindsInstance
import dagger.Subcomponent

/**
 * Created by jerry on 2021/03/28
 **/
@ActivityScope
@Subcomponent
interface LocationComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance context: Context) : LocationComponent
    }

    fun inject(mainActivity: MainActivity)
}