package com.example.gitprofiledesc.data.repository.profile.dataSource

import com.example.gitprofiledesc.data.model.ProfileData
import retrofit2.Response

interface ProfileRemoteRepo {
    suspend fun getProfileRemote(username:String):Response<ProfileData>
}