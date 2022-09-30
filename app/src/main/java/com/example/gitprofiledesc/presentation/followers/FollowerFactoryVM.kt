package com.example.gitprofiledesc.presentation.followers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gitprofiledesc.domain.followers.GetFollowersUseCase

class FollowerFactoryVM(
    private var followersUseCase: GetFollowersUseCase
) :ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FollowerViewModel(followersUseCase) as T
    }

}