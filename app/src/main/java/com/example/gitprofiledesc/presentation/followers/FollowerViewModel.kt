package com.example.gitprofiledesc.presentation.followers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.gitprofiledesc.domain.followers.GetFollowersUseCase

class FollowerViewModel(private var followersUseCase: GetFollowersUseCase) :ViewModel(){
    fun getFollowers(userName:String) = liveData {
      var response =  followersUseCase.execute(userName)
        emit(response)
    }

}