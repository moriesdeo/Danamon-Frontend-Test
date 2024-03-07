package com.danamon.test.ui.home.ui.dashboard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.danamon.test.databinding.ItemRegisterBinding
import com.danamon.test.ui.Register

class RegisterAdapter() : ListAdapter<Register, RegisterAdapter.ViewHolder>(RegisterDiffCallBack) {
    object RegisterDiffCallBack : DiffUtil.ItemCallback<Register>() {
        override fun areItemsTheSame(oldItem: Register, newItem: Register): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Register, newItem: Register): Boolean =
            oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegisterAdapter.ViewHolder {
        return ViewHolder(
            ItemRegisterBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RegisterAdapter.ViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    inner class ViewHolder(val binding: ItemRegisterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Register) {
            binding.apply {
                idTv.text = "id :" + data.id.toString()
                usernameTv.text = "Username :" + data.name
                emailTv.text = "Email :" + data.email
                roleTv.text = "Role :" + data.role
            }
        }
    }
}
