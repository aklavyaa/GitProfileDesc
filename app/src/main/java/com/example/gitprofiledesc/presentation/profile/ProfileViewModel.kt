package com.example.gitprofiledesc.presentation.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.gitprofiledesc.data.model.ProfileData
import com.example.gitprofiledesc.domain.profile.ProfileDetailUseCase
import com.example.gitprofiledesc.domain.profile.ProfileUpdateDetailUseCase
import com.example.gitprofiledesc.utils.AppUtils
import com.example.gitprofiledesc.utils.NetworkResponse
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val profileDetailUseCase: ProfileDetailUseCase,
    private val updateDetailUseCase: ProfileUpdateDetailUseCase,

    ):ViewModel() {


    private var successResult = MutableLiveData<ProfileData>()
    private var errorResult = MutableLiveData<String>()

    fun getProfileSuccessResult() : MutableLiveData<ProfileData>{
        return successResult
    }
    fun getErrorResult() : MutableLiveData<String>{
        return errorResult
    }

         fun getProfile(username:String)  {
            viewModelScope.launch{
                val response =  profileDetailUseCase.execute(username)
                when (response){
                    is NetworkResponse.NetworkResult.Success -> successResult.value = response.data
                    is NetworkResponse.NetworkResult.Error -> errorResult.value = response.message.toString()
                    is NetworkResponse.NetworkResult.Exception -> errorResult.value = response.e.message
                }
            }

        }

    fun updateProfile(username:String)  {

        AppUtils.userName = username

        viewModelScope.launch{
            val response =  updateDetailUseCase.execute(username)
            when (response){
                is NetworkResponse.NetworkResult.Success -> successResult.value = response.data
                is NetworkResponse.NetworkResult.Error -> errorResult.value = response.message.toString()
                is NetworkResponse.NetworkResult.Exception -> errorResult.value = response.e.message
            }
        }

    }

//        fun updateProfile() = liveData {
//           val updateProfileData = updateDetailUseCase.execute()
//            emit(updateProfileData)
//        }
//






    }



