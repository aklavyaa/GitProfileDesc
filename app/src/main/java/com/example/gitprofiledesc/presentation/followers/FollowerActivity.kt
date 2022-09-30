package com.example.gitprofiledesc.presentation.followers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gitprofiledesc.R
import com.example.gitprofiledesc.databinding.ActivityFollowerBinding
import com.example.gitprofiledesc.presentation.di.injector
import javax.inject.Inject

class FollowerActivity : AppCompatActivity() {

    @Inject
    lateinit var followerFactoryVM: FollowerFactoryVM
    lateinit var followerVm : FollowerViewModel
    lateinit var binding:ActivityFollowerBinding
    lateinit var adapter: FollowerAdapter

    val TAG = FollowerActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_follower)

        (application as injector).createFollowerSubComponent().inject(this)

        followerVm = ViewModelProvider(this,followerFactoryVM).get(FollowerViewModel::class.java)

        adapter = FollowerAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter =  adapter



        var response = followerVm.getFollowers()

        response.observe(this, Observer {
            adapter.setList(it)
            adapter.notifyDataSetChanged()
        })
    }
}