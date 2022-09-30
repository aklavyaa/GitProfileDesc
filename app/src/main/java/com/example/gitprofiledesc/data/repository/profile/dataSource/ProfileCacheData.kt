package com.example.gitprofiledesc.data.repository.profile.dataSource

import com.example.gitprofiledesc.data.model.ProfileData

interface ProfileCacheData {
    suspend fun getProfileCache():ProfileData?
    suspend fun updateProfileCache(data: ProfileData)
}