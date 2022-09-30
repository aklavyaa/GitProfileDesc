package com.example.gitprofiledesc.presentation.di.core

import com.example.gitprofiledesc.presentation.di.follower.FollowerSubComponent
import com.example.gitprofiledesc.presentation.di.following.FollowingSubComponent
import com.example.gitprofiledesc.presentation.di.profile.ProfileSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    CacheRepoModule::class,
    DatabaseModule::class,
    LocalRepoModule::class,
    NetModule::class,
    RemoteRepoModule::class,
    RepoModule::class,
    UseCaseModule::class
])
interface AppComponent {
    fun profileSubComponent():ProfileSubComponent.Factory
    fun followerSubComponent():FollowerSubComponent.Factory
    fun followingSubComponent(): FollowingSubComponent.Factory

}