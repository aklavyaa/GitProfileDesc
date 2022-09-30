package com.example.gitprofiledesc.data.db

//import android.arch.persistence.room.Dao
//import android.arch.persistence.room.Insert
//import android.arch.persistence.room.OnConflictStrategy
//import android.arch.persistence.room.Query
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.gitprofiledesc.data.model.ProfileData
@Dao
interface ProfileDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveProfile(profile:ProfileData)

    @Query(value = "DELETE  FROM profile_data")
    suspend fun deleteProfile()

    @Query(value = "SELECT * FROM profile_data")
    suspend fun getProfile():ProfileData
}