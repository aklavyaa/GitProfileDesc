package com.example.gitprofiledesc.domain.profile

import com.example.gitprofiledesc.data.model.ProfileData
import com.example.gitprofiledesc.utils.NetworkResponse

class ProfileUpdateDetailUseCase (private var profileRepo: ProfileRepo){
//    suspend fun execute(){
//        profileRepo.updateProfileDetail()
//    }

    suspend fun execute(username:String): NetworkResponse.NetworkResult<ProfileData>{
        return profileRepo.updateProfileDetail(username)
    }
}