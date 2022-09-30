package com.example.gitprofiledesc.presentation.di.core

import com.example.gitprofiledesc.data.api.ApiService
import com.example.gitprofiledesc.data.repository.followers.dataSource.FollowersRemoteRepo
import com.example.gitprofiledesc.data.repository.followers.dataImpl.FollowersRemoteRepoImpl
import com.example.gitprofiledesc.data.repository.following.dataImpl.RemoteRepoFollowingImpl
import com.example.gitprofiledesc.data.repository.following.dataSource.RemoteRepoFollowing
import com.example.gitprofiledesc.data.repository.profile.dataImpl.ProfileRemoteRepoImpl
import com.example.gitprofiledesc.data.repository.profile.dataSource.ProfileRemoteRepo
import dagger.Module
import dagger.Provides

@Module
class RemoteRepoModule {
    @Provides
    fun provideProfileRemoteDataSource(apiService: ApiService):ProfileRemoteRepo{
        return ProfileRemoteRepoImpl(apiService)
    }

    @Provides
    fun provideFollowerRemoteRepo(apiService: ApiService): FollowersRemoteRepo {
        return FollowersRemoteRepoImpl(apiService)
    }

    @Provides
    fun provideFollowingRemoteRepo(
        apiService: ApiService
    ): RemoteRepoFollowing {
        return RemoteRepoFollowingImpl(apiService)
    }




}