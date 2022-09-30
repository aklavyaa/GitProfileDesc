package com.example.gitprofiledesc.domain.followers

import com.example.gitprofiledesc.data.model.followers.FollowersModelItem

class GetFollowersUseCase(private val followerRepo: FollowerRepo) {
    suspend fun execute():ArrayList<FollowersModelItem>{
         return followerRepo.provideFollowersList()
    }
}