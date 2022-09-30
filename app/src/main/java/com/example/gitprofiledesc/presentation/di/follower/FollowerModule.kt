package com.example.gitprofiledesc.presentation.di.follower

import com.example.gitprofiledesc.domain.followers.GetFollowersUseCase
import com.example.gitprofiledesc.presentation.followers.FollowerFactoryVM
import dagger.Module
import dagger.Provides

@Module
class FollowerModule {

    @Provides
    fun provideFollowerFactoryVM(
        getFollowersUseCase: GetFollowersUseCase
    ): FollowerFactoryVM {
        return FollowerFactoryVM(getFollowersUseCase)
    }

}