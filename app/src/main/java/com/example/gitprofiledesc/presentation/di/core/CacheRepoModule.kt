package com.example.gitprofiledesc.presentation.di.core

import com.example.gitprofiledesc.data.repository.profile.dataImpl.ProfileCacheDataImpl
import com.example.gitprofiledesc.data.repository.profile.dataSource.ProfileCacheData
import dagger.Module
import dagger.Provides

@Module
class CacheRepoModule {
    @Provides
    fun provideProfileCacheData():ProfileCacheData{
        return ProfileCacheDataImpl()
    }
}