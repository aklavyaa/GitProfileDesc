package com.example.gitprofiledesc.presentation.following

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gitprofiledesc.R
import com.example.gitprofiledesc.databinding.ActivityFollowingBinding
import com.example.gitprofiledesc.presentation.di.injector
import javax.inject.Inject

class FollowingActivity : AppCompatActivity() {

    val TAG = FollowingActivity::class.java.simpleName
    private lateinit var binding: ActivityFollowingBinding

    @Inject
    lateinit var followingFactoryVM: FollowingFactoryVM

     var adapter = FollowingAdapter()

    private lateinit var followingVM: FollowingViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_following)
        (application as injector).createFollowingSubComponent().inject(this)
        followingVM = ViewModelProvider(this,followingFactoryVM)[FollowingViewModel::class.java]

       binding.recyclerView3.layoutManager = LinearLayoutManager(this)
       binding.recyclerView3.adapter =  adapter

        var response = followingVM.provideFollowingList()
        response.observe(this, Observer {
            adapter.setList(it)
            adapter.notifyDataSetChanged()
        })



    }
}