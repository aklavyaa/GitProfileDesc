package com.example.gitprofiledesc.data.repository.profile.dataImpl

import android.util.Log
import com.example.gitprofiledesc.data.model.ProfileData
import com.example.gitprofiledesc.data.repository.profile.dataSource.ProfileCacheData

class ProfileCacheDataImpl: ProfileCacheData {
       var profileCache:ProfileData? = null
    override suspend fun getProfileCache(): ProfileData? {
        return profileCache
    }

    override suspend fun updateProfileCache(data: ProfileData) {
        Log.e("check", "check: " )
        profileCache = data
        Log.e("check", "check: " )
//        profileCache = ProfileData()
//        profileCache = ProfileData()
    }
}