package com.example.gitprofiledesc.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.gitprofiledesc.data.model.ProfileData

@Database(
    entities = [ProfileData::class],
    version = 1,
    exportSchema = false
)
abstract class TestDatabase : RoomDatabase() {
    abstract fun getProfileDao(): ProfileDao

}