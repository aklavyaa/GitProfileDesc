package com.example.gitprofiledesc.data.repository.following

import com.example.gitprofiledesc.data.model.following.FollowingModelItem
import com.example.gitprofiledesc.data.repository.following.dataSource.RemoteRepoFollowing
import com.example.gitprofiledesc.domain.following.RepoFollowing

class RepoFollowingImpl(private var remoteRepoFollowing: RemoteRepoFollowing):RepoFollowing {
    override suspend fun getRepoFollowing(): ArrayList<FollowingModelItem> {
        return getFollowing()
    }


    suspend fun getFollowing():ArrayList<FollowingModelItem>{
      var followingList = ArrayList<FollowingModelItem>()
       var respoonse =  remoteRepoFollowing.getRemoteRepoFollowing()
        if (respoonse.isSuccessful){
            followingList = respoonse.body()!!
        }
        return followingList
    }
}