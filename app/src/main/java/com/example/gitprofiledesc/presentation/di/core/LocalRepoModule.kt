package com.example.gitprofiledesc.presentation.di.core

import com.example.gitprofiledesc.data.db.ProfileDao
import com.example.gitprofiledesc.data.repository.profile.dataImpl.ProfileLocalDataSourceImpl
import com.example.gitprofiledesc.data.repository.profile.dataSource.ProfileLocalDataSource
import dagger.Module
import dagger.Provides

@Module
class LocalRepoModule {
    @Provides
    fun provideProfileLocalSource(profileDao: ProfileDao): ProfileLocalDataSource{
        return ProfileLocalDataSourceImpl(profileDao)
    }
}