package com.example.gitprofiledesc.data.repository.following.dataSource

import com.example.gitprofiledesc.data.model.following.FollowingModelItem
import retrofit2.Response

interface RemoteRepoFollowing {
    suspend fun getRemoteRepoFollowing(userName:String):Response<ArrayList<FollowingModelItem>>
}