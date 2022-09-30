package com.example.gitprofiledesc.domain.profile

import com.example.gitprofiledesc.data.model.ProfileData
import com.example.gitprofiledesc.utils.NetworkResponse

class ProfileDetailUseCase (private var profileRepo: ProfileRepo){

    suspend fun execute(username:String): NetworkResponse.NetworkResult<ProfileData>{
        return profileRepo.getProfileDetail(username)
    }

}