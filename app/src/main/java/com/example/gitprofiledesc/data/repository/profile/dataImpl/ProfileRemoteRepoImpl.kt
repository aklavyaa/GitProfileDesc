package com.example.gitprofiledesc.data.repository.profile.dataImpl

import com.example.gitprofiledesc.data.api.ApiService
import com.example.gitprofiledesc.data.model.ProfileData
import com.example.gitprofiledesc.data.repository.profile.dataSource.ProfileRemoteRepo
import retrofit2.Response

open class ProfileRemoteRepoImpl(private val apiService: ApiService): ProfileRemoteRepo {
    override suspend fun getProfileRemote(username:String): Response<ProfileData> {
        return apiService.getProfile(username)
    }

}