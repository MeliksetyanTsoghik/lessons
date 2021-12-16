package com.example.lesson1.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson1.R
import com.example.lesson1.users
import com.squareup.picasso.Picasso

class UsersListAdapter: RecyclerView.Adapter<UsersListAdapter.UserHolder>() {

     class UserHolder(item: View) : RecyclerView.ViewHolder(item) {

        val nameTextView: TextView = item.findViewById(R.id.nameTextView)
        val mailTextView: TextView = item.findViewById(R.id.mailTextView)
        val imageView: ImageView = item.findViewById(R.id.profileImageView)


     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        return UserHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_users_list, parent, false))
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {

        holder.mailTextView.text = users[position].mail
        holder.nameTextView.text = users[position].login
        Picasso.get().load(users[position].imageUrl).into(holder.imageView)
    }

    override fun getItemCount(): Int = users.size


}