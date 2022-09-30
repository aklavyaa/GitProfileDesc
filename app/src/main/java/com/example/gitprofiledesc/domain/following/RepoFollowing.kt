package com.example.gitprofiledesc.domain.following

import com.example.gitprofiledesc.data.model.following.FollowingModelItem

interface RepoFollowing {
    suspend fun getRepoFollowing():ArrayList<FollowingModelItem>
}