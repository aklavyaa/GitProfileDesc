package com.example.gitprofiledesc.presentation.di.core

import com.example.gitprofiledesc.data.repository.followers.FollowerRepoImpl
import com.example.gitprofiledesc.data.repository.followers.dataSource.FollowersRemoteRepo
import com.example.gitprofiledesc.data.repository.following.RepoFollowingImpl
import com.example.gitprofiledesc.data.repository.following.dataSource.RemoteRepoFollowing
import com.example.gitprofiledesc.data.repository.profile.ProfileRepoImpl
import com.example.gitprofiledesc.data.repository.profile.dataSource.ProfileCacheData
import com.example.gitprofiledesc.data.repository.profile.dataSource.ProfileLocalDataSource
import com.example.gitprofiledesc.data.repository.profile.dataSource.ProfileRemoteRepo
import com.example.gitprofiledesc.domain.followers.FollowerRepo
import com.example.gitprofiledesc.domain.following.RepoFollowing
import com.example.gitprofiledesc.domain.profile.ProfileRepo
import dagger.Module
import dagger.Provides

@Module
class RepoModule {

    @Provides
    fun provideProfileRepoModule(
         profileRemoteRepo: ProfileRemoteRepo,
         profileLocalDataSource: ProfileLocalDataSource,
         profileCacheData: ProfileCacheData

    ): ProfileRepo {
        return ProfileRepoImpl(profileRemoteRepo,profileLocalDataSource,profileCacheData)
    }
    @Provides
    fun provideFollowerRepoModule(
        followersRemoteRepo: FollowersRemoteRepo
    ):FollowerRepo{
        return FollowerRepoImpl(followersRemoteRepo)

    }

    @Provides
    fun provideRepoFollowingModel(
        remoteRepoFollowing: RemoteRepoFollowing
    ): RepoFollowing {
        return RepoFollowingImpl(remoteRepoFollowing)
    }
}