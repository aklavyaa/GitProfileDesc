package com.example.gitprofiledesc.presentation.di.core

import com.example.gitprofiledesc.domain.followers.FollowerRepo
import com.example.gitprofiledesc.domain.followers.GetFollowersUseCase
import com.example.gitprofiledesc.domain.following.GetFollowingUseCase
import com.example.gitprofiledesc.domain.following.RepoFollowing
import com.example.gitprofiledesc.domain.profile.ProfileDetailUseCase
import com.example.gitprofiledesc.domain.profile.ProfileRepo
import com.example.gitprofiledesc.domain.profile.ProfileUpdateDetailUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun provideProfileDetailUseCase(
        profileRepo: ProfileRepo
    ): ProfileDetailUseCase {
        return ProfileDetailUseCase(profileRepo)
    }

    @Provides
    fun provideUpdateProfileUseCase(
        profileRepo: ProfileRepo
    ): ProfileUpdateDetailUseCase {
        return ProfileUpdateDetailUseCase(profileRepo)
    }
    @Provides
    fun provideFollowerUseCase(
        followerRepo: FollowerRepo):GetFollowersUseCase{
        return GetFollowersUseCase(followerRepo)
    }

    @Provides
    fun provideGetFollowingUseCase(
        repoFollowing: RepoFollowing
    ):GetFollowingUseCase{
        return GetFollowingUseCase(repoFollowing)
    }

}