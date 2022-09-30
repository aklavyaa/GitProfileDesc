package com.example.gitprofiledesc.domain.profile

import com.example.gitprofiledesc.data.model.ProfileData
import com.example.gitprofiledesc.utils.NetworkResponse

interface ProfileRepo {

    suspend fun getProfileDetail(userName:String): NetworkResponse.NetworkResult<ProfileData>
    suspend fun updateProfileDetail():NetworkResponse.NetworkResult<ProfileData>
}