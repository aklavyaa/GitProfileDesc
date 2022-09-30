package com.example.gitprofiledesc.data.repository.profile.dataImpl

import com.example.gitprofiledesc.data.db.ProfileDao
import com.example.gitprofiledesc.data.model.ProfileData
import com.example.gitprofiledesc.data.repository.profile.dataSource.ProfileLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileLocalDataSourceImpl(private val profileDao: ProfileDao): ProfileLocalDataSource {
    override suspend fun getProfileFromLocalDb(): ProfileData {
        return profileDao.getProfile()
    }

    override suspend fun updateProfileToLocalDb(data: ProfileData) {
        CoroutineScope(Dispatchers.IO).launch {
            profileDao.saveProfile(data)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            profileDao.deleteProfile()
        }
    }
}