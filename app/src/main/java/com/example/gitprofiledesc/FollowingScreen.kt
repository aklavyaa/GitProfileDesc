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
import com.example.gitprofiledesc.databinding.FragmentFollowingScreenBinding
import com.example.gitprofiledesc.presentation.di.injector
import com.example.gitprofiledesc.presentation.following.FollowingAdapter
import com.example.gitprofiledesc.presentation.following.FollowingFactoryVM
import com.example.gitprofiledesc.presentation.following.FollowingViewModel
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
 * Use the [FollowingScreen.newInstance] factory method to
 * create an instance of this fragment.
 */
class FollowingScreen : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null



    lateinit var binding:FragmentFollowingScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        binding = FragmentFollowingScreenBinding.inflate(layoutInflater,container,false)
        return binding.root
    }
    lateinit var skeleton: Skeleton



    @Inject
    lateinit var followingFactoryVM: FollowingFactoryVM

    var adapter = FollowingAdapter()
    private lateinit var followingVM: FollowingViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity?.application as injector).createFollowingSubComponent().inject(this)
        followingVM = ViewModelProvider(this,followingFactoryVM)[FollowingViewModel::class.java]

        binding.recyclerView3.layoutManager = LinearLayoutManager(requireActivity())
        binding.recyclerView3.adapter =  adapter

        skeleton = binding.recyclerView3.applySkeleton(R.layout.cell_view)
        skeleton.showSkeleton()
        var response = followingVM.provideFollowingList(AppUtils.userName)


        response.observe(requireActivity(), Observer {
            skeleton.showOriginal()
            adapter.setList(it)
            adapter.notifyDataSetChanged()
        })


    }

}