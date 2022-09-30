package com.example.gitprofiledesc.data.repository.followers

import com.example.gitprofiledesc.data.model.followers.FollowersModelItem
import com.example.gitprofiledesc.data.repository.followers.dataSource.FollowersRemoteRepo
import com.example.gitprofiledesc.domain.followers.FollowerRepo

class FollowerRepoImpl(private var followersRemoteRepo: FollowersRemoteRepo): FollowerRepo {
    override suspend fun provideFollowersList(): ArrayList<FollowersModelItem> {
        return getFollowers()
    }

    suspend fun getFollowers(): ArrayList<FollowersModelItem> {
        var followersList = ArrayList<FollowersModelItem>()
       var response =  followersRemoteRepo.getRemoteFollowers()
       if (response!= null){
          followersList = response.body()!!
       }
        return followersList
    }
}