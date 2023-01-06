package com.example.gitprofiledesc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gitprofiledesc.databinding.ActivityFollowerBinding
import com.example.gitprofiledesc.databinding.FragmentFollowersScreenBinding
import com.example.gitprofiledesc.presentation.di.injector
import com.example.gitprofiledesc.presentation.followers.FollowerAdapter
import com.example.gitprofiledesc.presentation.followers.FollowerFactoryVM
import com.example.gitprofiledesc.presentation.followers.FollowerViewModel
import com.example.gitprofiledesc.utils.AppUtils
import com.faltenreich.skeletonlayout.Skeleton
import com.faltenreich.skeletonlayout.applySkeleton
import com.faltenreich.skeletonlayout.createSkeleton
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FollowersScreen.newInstance] factory method to
 * create an instance of this fragment.
 */
class FollowersScreen : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    @Inject
    lateinit var followerFactoryVM: FollowerFactoryVM
    lateinit var followerVm : FollowerViewModel
    lateinit var adapter: FollowerAdapter


    lateinit var binding: FragmentFollowersScreenBinding

    lateinit var skeleton:Skeleton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding =  FragmentFollowersScreenBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        (activity?.application as injector).createFollowerSubComponent().inject(this)

        followerVm = ViewModelProvider(this,followerFactoryVM).get(FollowerViewModel::class.java)

        adapter = FollowerAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        binding.recyclerView.adapter =  adapter

        skeleton = binding.recyclerView.applySkeleton(R.layout.cell_view)


        var response = followerVm.getFollowers(AppUtils.userName)
        skeleton.showSkeleton()
        response.observe(requireActivity(), Observer {
            skeleton.showOriginal()
            adapter.setList(it)
            adapter.notifyDataSetChanged()

        })
    }


}