package com.example.gitprofiledesc.presentation.following

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.gitprofiledesc.domain.following.GetFollowingUseCase

class FollowingViewModel(private var getFollowingUseCase: GetFollowingUseCase): ViewModel() {

    fun provideFollowingList(userName:String)= liveData {
      var followinglist =   getFollowingUseCase.getFollowing(userName)
        emit(followinglist)
    }
}