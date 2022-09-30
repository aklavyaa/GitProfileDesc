package com.example.gitprofiledesc.data.repository.profile

import android.util.Log
import com.example.gitprofiledesc.data.model.ProfileData
import com.example.gitprofiledesc.data.repository.profile.dataSource.ProfileCacheData
import com.example.gitprofiledesc.data.repository.profile.dataSource.ProfileLocalDataSource
import com.example.gitprofiledesc.data.repository.profile.dataSource.ProfileRemoteRepo
import com.example.gitprofiledesc.domain.profile.ProfileRepo
import com.example.gitprofiledesc.utils.NetworkResponse

class ProfileRepoImpl(
    val profileRemoteRepo: ProfileRemoteRepo,
    val profileLocalDataSource: ProfileLocalDataSource,
    val profileCacheData: ProfileCacheData
    ): ProfileRepo {
    private val TAG = ProfileRepoImpl::class.java.simpleName
    private lateinit var username: String
     var errorMessage = ""

    override suspend fun getProfileDetail(username:String): NetworkResponse.NetworkResult<ProfileData> {
        this.username = username
        return getDataFromCache()
    }

    override suspend fun updateProfileDetail(): NetworkResponse.NetworkResult<ProfileData> {
        var newProfileData = getDataFromRemote(username)
        when (newProfileData){
            is NetworkResponse.NetworkResult.Success ->{
                profileLocalDataSource.clearAll()
                profileLocalDataSource.updateProfileToLocalDb(newProfileData.data)
                profileCacheData.updateProfileCache(newProfileData.data)
            }
        }

        return newProfileData
    }



    //response.errorBody().string()
    suspend fun getDataFromRemote(username: String):NetworkResponse.NetworkResult<ProfileData>{


        val response = profileRemoteRepo.getProfileRemote(username)
        var body = response.body()
        if (response.isSuccessful && body!=null){
            profileLocalDataSource.updateProfileToLocalDb(body)
        }
       return NetworkResponse.handleApi { response }
       //
       //       try {
//           val response = profileRemoteRepo.getProfileRemote(username)
//
//           val body = response.body()
//           if (body!=null){
//               remoteProfileData = body
//           } else {
//               errorMessage = response.errorBody()?.string().toString()
//               handleError()
//           }
//       }catch (exception:Exception){
//           Log.e("MyTag", "getDataFromRemote: "+exception )
//       }
//        return remoteProfileData
    }

    suspend fun getDataFromLocalDatabase():NetworkResponse.NetworkResult<ProfileData>{
         var localProfileData:ProfileData?


        localProfileData = profileLocalDataSource.getProfileFromLocalDb()
        if (localProfileData == null){
            var response = getDataFromRemote(username)
            return response
        }else {
            profileCacheData.updateProfileCache(localProfileData)
           return NetworkResponse.NetworkResult.Success(localProfileData)
        }
    }

    suspend fun getDataFromCache():NetworkResponse.NetworkResult<ProfileData>{
        var cacheProfile: ProfileData?

        cacheProfile = profileCacheData.getProfileCache()
        if (cacheProfile == null){
           return getDataFromLocalDatabase()
        } else {
            Log.e(TAG, "getDataFromCache: " )
            return NetworkResponse.NetworkResult.Success(cacheProfile)
        }

    }

}