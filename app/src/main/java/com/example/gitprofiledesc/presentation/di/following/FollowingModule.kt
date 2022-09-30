package com.example.gitprofiledesc.presentation.di.following

import com.example.gitprofiledesc.domain.following.GetFollowingUseCase
import com.example.gitprofiledesc.presentation.following.FollowingFactoryVM
import dagger.Module
import dagger.Provides
@Module
class FollowingModule {
    @FollowingScope
    @Provides
    fun provideFollowingFactoryVM(
        getFollowingUseCase: GetFollowingUseCase
    ): FollowingFactoryVM {
        return FollowingFactoryVM(getFollowingUseCase)
    }
}