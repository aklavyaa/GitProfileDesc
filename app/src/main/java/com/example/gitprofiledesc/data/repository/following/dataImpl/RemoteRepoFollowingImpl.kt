package com.example.gitprofiledesc.data.repository.following.dataImpl

import com.example.gitprofiledesc.data.api.ApiService
import com.example.gitprofiledesc.data.model.following.FollowingModelItem
import com.example.gitprofiledesc.data.repository.following.dataSource.RemoteRepoFollowing
import retrofit2.Response

class RemoteRepoFollowingImpl(private var apiService: ApiService) : RemoteRepoFollowing{
    override suspend fun getRemoteRepoFollowing(): Response<ArrayList<FollowingModelItem>> {
       return apiService.getFollowing()
    }
}