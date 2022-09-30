package com.example.gitprofiledesc.data.repository.followers.dataImpl

import com.example.gitprofiledesc.data.api.ApiService
import com.example.gitprofiledesc.data.model.followers.FollowersModelItem
import com.example.gitprofiledesc.data.repository.followers.dataSource.FollowersRemoteRepo
import retrofit2.Response

class FollowersRemoteRepoImpl(private var apiService: ApiService): FollowersRemoteRepo {
    override suspend fun getRemoteFollowers(): Response<ArrayList<FollowersModelItem>> {
       return apiService.getFollowers()
    }
}