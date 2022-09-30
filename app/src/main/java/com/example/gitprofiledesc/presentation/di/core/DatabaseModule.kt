package com.example.gitprofiledesc.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.gitprofiledesc.data.db.ProfileDao
import com.example.gitprofiledesc.data.db.TestDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context):TestDatabase{
        return Room.databaseBuilder(context,TestDatabase::class.java,"database_client").build()
    }

    @Singleton
    @Provides
    fun provideProfileDao(testDatabase: TestDatabase):ProfileDao{
        return testDatabase.getProfileDao()
    }

}