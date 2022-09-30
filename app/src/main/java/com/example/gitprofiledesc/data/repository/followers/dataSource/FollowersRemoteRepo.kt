package com.example.gitprofiledesc.data.repository.followers.dataSource

import com.example.gitprofiledesc.data.model.followers.FollowersModelItem
import retrofit2.Response

interface FollowersRemoteRepo {
    suspend fun getRemoteFollowers():Response<ArrayList<FollowersModelItem>>?



}