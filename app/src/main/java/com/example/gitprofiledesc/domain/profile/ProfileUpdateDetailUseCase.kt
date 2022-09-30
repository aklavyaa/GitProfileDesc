package com.example.gitprofiledesc.domain.profile

class ProfileUpdateDetailUseCase (private var profileRepo: ProfileRepo){
    suspend fun execute(){
        profileRepo.updateProfileDetail()
    }
}