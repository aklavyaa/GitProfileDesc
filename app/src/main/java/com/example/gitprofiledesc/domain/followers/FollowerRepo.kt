package com.example.gitprofiledesc.domain.followers

import com.example.gitprofiledesc.data.model.followers.FollowersModelItem

interface FollowerRepo {
    suspend fun provideFollowersList():ArrayList<FollowersModelItem>
}