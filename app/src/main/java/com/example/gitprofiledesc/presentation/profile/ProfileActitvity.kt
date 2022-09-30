package com.example.gitprofiledesc.presentation.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.gitprofiledesc.R
import com.example.gitprofiledesc.databinding.ActivityMainBinding
import com.example.gitprofiledesc.presentation.following.FollowingActivity
import com.example.gitprofiledesc.presentation.di.injector
import com.example.gitprofiledesc.presentation.followers.FollowerActivity
import javax.inject.Inject

class ProfileActitvity : AppCompatActivity() {

    @Inject
     lateinit var profileVMFactory: ProfileFactoryVM
    private lateinit var profileViewModel: ProfileViewModel
    private val TAG = ProfileActitvity::class.java.simpleName
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        (application as injector).createProfileSubComponent().inject(this)
        profileViewModel = ViewModelProvider(this,profileVMFactory).get(ProfileViewModel::class.java)
        profileViewModel.getProfile("JakeWharton")
        profileViewModel.getProfileSuccessResult().observe(this, Observer {
            Log.e(TAG, "onCreate: "+it.name)
            binding.apply {
                Glide.with(this@ProfileActitvity).load(it.avatarUrl).into(profileImage)
                name.text = it.name
                positon.text = it.company
                bio.text = it.location
                followers.paint.isUnderlineText = true
                following.paint.isUnderlineText = true
                followers.text = "${it.followers} followers"
                following.text = "${it.following} following"
            }
        })


        profileViewModel.getErrorResult().observe(this, Observer {
            Toast.makeText(this@ProfileActitvity,it,Toast.LENGTH_SHORT).show()
        })

        binding.followers.setOnClickListener {
            startActivity(Intent(this@ProfileActitvity,FollowerActivity::class.java))
        }

        binding.following.setOnClickListener {
            startActivity(Intent(this@ProfileActitvity,FollowingActivity::class.java))
        }
    }


}