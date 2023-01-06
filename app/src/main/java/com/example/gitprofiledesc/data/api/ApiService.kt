package com.example.gitprofiledesc.data.api

import com.example.gitprofiledesc.data.model.ProfileData
import com.example.gitprofiledesc.data.model.followers.FollowersModelItem
import com.example.gitprofiledesc.data.model.following.FollowingModelItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("users/{username}")
    suspend fun getProfile(@Path("username") username:String): Response<ProfileData>
    @GET("users/{username}/followers")
    suspend fun getFollowers(@Path("username") username:String): Response<ArrayList<FollowersModelItem>>
    @GET("users/{username}/following")
    suspend fun getFollowing(@Path("username") username:String): Response<ArrayList<FollowingModelItem>>
}