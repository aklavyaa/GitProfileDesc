package com.example.gitprofiledesc.presentation.following

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.gitprofiledesc.R
import com.example.gitprofiledesc.data.model.following.FollowingModelItem
import com.example.gitprofiledesc.databinding.CellViewBinding

class FollowingAdapter: RecyclerView.Adapter<FollowingAdapter.FollowerView>() {
    private val followingList = ArrayList<FollowingModelItem>()


    fun setList(arrayList: ArrayList<FollowingModelItem>){
        followingList.clear()
        followingList.addAll(arrayList)
    }
    class FollowerView(val binding:CellViewBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(followersModelItem: FollowingModelItem){
            binding.name.text =followersModelItem.id.toString()
            binding.positon.text = followersModelItem.login
            binding.bio.text = followersModelItem.type
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerView {
        var  layoutInflater = LayoutInflater.from(parent.context)
        var binding :CellViewBinding = DataBindingUtil.inflate(layoutInflater, R.layout.cell_view,parent,false)
        return FollowerView(binding)
    }

    override fun onBindViewHolder(holder: FollowerView, position: Int) {
        holder.bind(followingList[position])
    }

    override fun getItemCount(): Int {
        return followingList.size
    }
}