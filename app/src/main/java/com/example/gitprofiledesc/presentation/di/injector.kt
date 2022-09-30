package com.example.gitprofiledesc.presentation.di

import com.example.gitprofiledesc.presentation.di.follower.FollowerSubComponent
import com.example.gitprofiledesc.presentation.di.following.FollowingSubComponent
import com.example.gitprofiledesc.presentation.di.profile.ProfileSubComponent

interface injector {
    fun createProfileSubComponent():ProfileSubComponent
    fun createFollowerSubComponent():FollowerSubComponent
    fun createFollowingSubComponent(): FollowingSubComponent

}