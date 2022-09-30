package com.example.gitprofiledesc.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gitprofiledesc.domain.profile.ProfileDetailUseCase
import com.example.gitprofiledesc.domain.profile.ProfileUpdateDetailUseCase

class ProfileFactoryVM(
    private val profileDetailUseCase: ProfileDetailUseCase,
    private val updateDetailUseCase: ProfileUpdateDetailUseCase,


    ): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ProfileViewModel(profileDetailUseCase,updateDetailUseCase) as T

    }


}