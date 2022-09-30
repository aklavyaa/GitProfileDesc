package com.example.gitprofiledesc.data.repository.profile.dataSource

import com.example.gitprofiledesc.data.model.ProfileData

interface ProfileLocalDataSource {
    suspend fun getProfileFromLocalDb():ProfileData?
    suspend fun updateProfileToLocalDb(data:ProfileData)
    suspend fun clearAll()
}