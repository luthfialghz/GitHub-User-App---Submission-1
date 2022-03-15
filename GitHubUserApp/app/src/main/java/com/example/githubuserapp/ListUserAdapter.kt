package com.example.myrecyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubuserapp.DetailUser
import com.example.githubuserapp.MainActivity
import com.example.githubuserapp.R

class ListUserAdapter(private val listUser: ArrayList<User>) : RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_user, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (username, fullname, company, avatar, repository, followers, following) = listUser[position]
        Glide.with(holder.itemView.context)
            .load(avatar)
            .circleCrop()
            .into(holder.imgPhoto)
        holder.tvUsername.text = username
        holder.tvFullName.text = fullname
        holder.tvCompany.text = company


        holder.itemView.setOnClickListener {
            val user = User(
                username,
                fullname,
                company,
                avatar,
                repository,
                followers,
                following
            )
            var moveWithObjectIntent = Intent(holder.itemView.context,DetailUser::class.java)
            moveWithObjectIntent.putExtra(DetailUser.EXTRA_PERSON, user)
            holder.itemView.context.startActivity(moveWithObjectIntent)
        }
    }

    override fun getItemCount(): Int = listUser.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_avatar)
        var tvUsername: TextView = itemView.findViewById(R.id.tv_item_username)
        var tvFullName: TextView = itemView.findViewById(R.id.tv_item_fullname)
        var tvCompany: TextView = itemView.findViewById(R.id.tv_item_company)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: User)
    }
}