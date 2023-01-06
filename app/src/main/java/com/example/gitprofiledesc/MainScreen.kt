package com.example.gitprofiledesc

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.gitprofiledesc.databinding.FragmentMainScreenBinding
import com.example.gitprofiledesc.presentation.di.injector
import com.example.gitprofiledesc.presentation.profile.ProfileFactoryVM
import com.example.gitprofiledesc.presentation.profile.ProfileViewModel
import com.example.gitprofiledesc.utils.AppUtils
import com.faltenreich.skeletonlayout.Skeleton
import com.faltenreich.skeletonlayout.createSkeleton
import kotlinx.coroutines.handleCoroutineException
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainScreen.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainScreen : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    lateinit var binding:FragmentMainScreenBinding

    @Inject
    lateinit var profileVMFactory: ProfileFactoryVM
    private lateinit var profileViewModel: ProfileViewModel

    private val TAG = MainScreen::class.java.simpleName




    private lateinit var skeleton: Skeleton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

       binding =  FragmentMainScreenBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity?.application as injector).createProfileSubComponent().inject(this)
        profileViewModel = ViewModelProvider(this,profileVMFactory).get(ProfileViewModel::class.java)

        skeleton = binding.mainview.createSkeleton()
        binding.swiperefresh.setOnRefreshListener {
            skeleton.showSkeleton()
            profileViewModel.updateProfile(AppUtils.userName)
        }

        profileViewModel.getProfileSuccessResult().observe(requireActivity(), Observer {

            skeleton.showOriginal()
            binding.mainview.visibility = View.VISIBLE

            binding.swiperefresh.isRefreshing = false


            Log.e(TAG, "onCreate: "+it.name)
            binding.apply {
                Glide.with(
                    requireActivity())
                    .load(it.avatarUrl)
                    .placeholder(R.drawable.avatar)
                    .into(profileImage)
                name.text = it.name
                positon.text = it.company
                bio.text = it.location
                followers.paint.isUnderlineText = true
                following.paint.isUnderlineText = true
                followers.text = "${it.followers} followers"
                following.text = "${it.following} following"
            }
        })

        binding.search.setOnEditorActionListener(object : TextView.OnEditorActionListener{
            override fun onEditorAction(p0: TextView?, p1: Int, p2: KeyEvent?): Boolean {
                var handled = false

                if (p1 == EditorInfo.IME_ACTION_DONE) {
                    skeleton.showSkeleton()
                    profileViewModel.updateProfile(p0?.text.toString())
                    handled = true;
                }
                return handled
            }

        })

        profileViewModel.getErrorResult().observe(requireActivity(), Observer {

            skeleton.showOriginal()
            binding.swiperefresh.isRefreshing = false
            binding.mainview.visibility = View.GONE
        })

        binding.followers.setOnClickListener {
            findNavController().navigate(R.id.action_mainScreen_to_followersScreen)
        }

        binding.following.setOnClickListener {
            findNavController().navigate(R.id.action_mainScreen_to_followingScreen)
        }

    }


}