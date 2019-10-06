package com.tertychnyi.alex.amconsofttest.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.tertychnyi.alex.amconsofttest.R
import com.tertychnyi.alex.amconsofttest.databinding.ItemUserBinding
import com.tertychnyi.alex.amconsofttest.presentation.base.BaseAdapter
import com.tertychnyi.alex.amconsofttest.presentation.item.IUserItemClickListener
import com.tertychnyi.alex.amconsofttest.presentation.item.UserViewHolder
import com.tertychnyi.alex.amconsofttest.usecases.repository.database.entity.UserEntity

class UserAdapter(private val context: Context, private val users: List<UserEntity>, private val listener: IUserItemClickListener<UserEntity>):
    BaseAdapter<UserViewHolder, UserEntity, IUserItemClickListener<UserEntity>>(users as MutableList<UserEntity>, listener) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        var inflater : LayoutInflater = LayoutInflater.from(context)
        var binding : ItemUserBinding = DataBindingUtil.inflate(inflater, R.layout.item_user, parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.bind(users[position], listener)
    }

    override fun getItemCount(): Int {
        return users.size
    }

}