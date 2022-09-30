package com.example.gitprofiledesc.presentation.followers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.gitprofiledesc.R
import com.example.gitprofiledesc.data.model.followers.FollowersModelItem
import com.example.gitprofiledesc.databinding.CellViewBinding

class FollowerAdapter: RecyclerView.Adapter<FollowerAdapter.FollowerView>() {
    private val followerList = ArrayList<FollowersModelItem>()


    fun setList(arrayList: ArrayList<FollowersModelItem>){
        followerList.clear()
        followerList.addAll(arrayList)
    }
    class FollowerView(val binding:CellViewBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(followersModelItem: FollowersModelItem){
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
        holder.bind(followerList[position])
    }

    override fun getItemCount(): Int {
        return followerList.size
    }
}