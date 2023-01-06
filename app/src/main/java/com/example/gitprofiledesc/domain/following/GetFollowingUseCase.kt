package com.example.gitprofiledesc.domain.following

import com.example.gitprofiledesc.data.model.following.FollowingModelItem

class GetFollowingUseCase (private var repoFollowing: RepoFollowing){

    suspend fun getFollowing(userName:String):ArrayList<FollowingModelItem>{
        return repoFollowing.getRepoFollowing(userName)
    }
}