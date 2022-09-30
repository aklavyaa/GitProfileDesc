package com.example.gitprofiledesc.presentation.following

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gitprofiledesc.domain.following.GetFollowingUseCase

class FollowingFactoryVM(private var getFollowingUseCase: GetFollowingUseCase) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FollowingViewModel(getFollowingUseCase) as T
    }
}