package com.tertychnyi.alex.amconsofttest.presentation.activities.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.tertychnyi.alex.amconsofttest.R
import com.tertychnyi.alex.amconsofttest.di.component.ViewModelComponent
import com.tertychnyi.alex.amconsofttest.domain.ListUsersViewModel
import com.tertychnyi.alex.amconsofttest.presentation.activities.auth.AuthActivity
import com.tertychnyi.alex.amconsofttest.presentation.activities.detail.DetailActivity
import com.tertychnyi.alex.amconsofttest.presentation.adapter.UserAdapter
import com.tertychnyi.alex.amconsofttest.presentation.base.BaseActivity
import com.tertychnyi.alex.amconsofttest.presentation.item.IUserItemClickListener
import com.tertychnyi.alex.amconsofttest.usecases.repository.database.entity.UserEntity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    companion object {
        @JvmStatic
        fun newInstance(context: Context): Intent {
            val intent = Intent(context, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            return intent
        }
    }

    var viewModel: ListUsersViewModel?= null
        @Inject set

    private val itemClickListener = object : IUserItemClickListener<UserEntity> {
        override fun openDetail(entity: UserEntity) {
            openItemDetail(entity.id)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
        viewModel?.getAllItems()
        viewModel?.getLiveDataItems()?.observe(this, Observer { it?.let { initRecyclerView(it) } })
    }

    override fun injectDependency(component: ViewModelComponent) {
        component.inject(this)
    }

    private fun initUI() {
        val user = getFirebaseAuth().currentUser
        if (user != null) {
            tvUserName.text = user!!.displayName
            tvUserMail.text = user!!.email
            Glide.with(this)
                .load(user!!.photoUrl)
                .into(ivUserAvatar)
        }
        initActionBar(user?.displayName.toString())
        btnSignOut.setOnClickListener { doSignOut() }
    }

    private fun initActionBar(title: String) {
        Objects.requireNonNull(supportActionBar)?.title = title
    }

    private fun initRecyclerView(users: List<UserEntity>) {
        if (users.isNotEmpty()) {
            rvUsers.visibility = View.VISIBLE
            tvMessage.visibility = View.GONE
            val manager = LinearLayoutManager(this)
            val adapter = UserAdapter(this, users, itemClickListener)
            adapter.setItemClickListener(itemClickListener)
            rvUsers.layoutManager = manager
            rvUsers.adapter = adapter
        }
        else {
            rvUsers.visibility = View.GONE
            tvMessage.visibility = View.VISIBLE
        }
    }

    private fun openItemDetail(id: Int) {
        startActivity(DetailActivity.newInstance(this, id))
    }

    private fun doSignOut() {
        getFirebaseAuth().signOut()
        startActivity(AuthActivity.newInstance(this))
        finish()
    }
}