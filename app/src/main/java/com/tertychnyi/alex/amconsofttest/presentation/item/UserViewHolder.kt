package com.tertychnyi.alex.amconsofttest.presentation.item

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.tertychnyi.alex.amconsofttest.databinding.ItemUserBinding
import com.tertychnyi.alex.amconsofttest.usecases.repository.database.entity.UserEntity
import kotlinx.android.synthetic.main.item_user.view.*

class UserViewHolder(private val binding: ItemUserBinding): RecyclerView.ViewHolder(binding.getRoot()) {

    fun bind(userEntity: UserEntity, listener: IUserItemClickListener<UserEntity>) {
        binding.user = userEntity
        binding.listener = listener
        binding.executePendingBindings()
    }

}