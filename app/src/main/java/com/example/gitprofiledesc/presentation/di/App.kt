package com.example.gitprofiledesc.presentation.di

import android.app.Application
import com.example.gitprofiledesc.presentation.di.core.AppComponent
import com.example.gitprofiledesc.presentation.di.core.AppModule
import com.example.gitprofiledesc.presentation.di.core.DaggerAppComponent
import com.example.gitprofiledesc.presentation.di.core.NetModule
import com.example.gitprofiledesc.presentation.di.follower.FollowerSubComponent
import com.example.gitprofiledesc.presentation.di.following.FollowingSubComponent
import com.example.gitprofiledesc.presentation.di.profile.ProfileSubComponent

class App: Application(),injector {

    private lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule("https://api.github.com/"))
            .build()
//        appComponent = DaggerAppComponent.builder()
//        appComponent =
    }
    override fun createProfileSubComponent(): ProfileSubComponent {
        return appComponent.profileSubComponent().create()
    }

    override fun createFollowerSubComponent(): FollowerSubComponent {
        return appComponent.followerSubComponent().create()
    }

    override fun createFollowingSubComponent(): FollowingSubComponent {
        return appComponent.followingSubComponent().create()
    }
}