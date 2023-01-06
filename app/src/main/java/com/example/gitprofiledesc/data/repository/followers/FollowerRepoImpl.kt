package com.example.gitprofiledesc.data.repository.followers

import com.example.gitprofiledesc.data.model.followers.FollowersModelItem
import com.example.gitprofiledesc.data.repository.followers.dataSource.FollowersRemoteRepo
import com.example.gitprofiledesc.domain.followers.FollowerRepo

class FollowerRepoImpl(private var followersRemoteRepo: FollowersRemoteRepo): FollowerRepo {
    override suspend fun provideFollowersList(userName:String): ArrayList<FollowersModelItem> {
        return getFollowers(userName)
    }

    suspend fun getFollowers(userName: String): ArrayList<FollowersModelItem> {
        var followersList = ArrayList<FollowersModelItem>()
       var response =  followersRemoteRepo.getRemoteFollowers(userName)
       if (response!= null){
          followersList = response.body()!!
       }
        return followersList
    }
}