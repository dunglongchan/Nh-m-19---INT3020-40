package com.example.momo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.momo.databinding.ItemSuggestBinding
import com.example.momo.model.MomoSuggestModel

class MomoSuggestAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listItem: ArrayList<MomoSuggestModel> = ArrayList()

    fun setData(list: ArrayList<MomoSuggestModel>) {
        this.listItem.clear()
        this.listItem.addAll(list)
    }

    class ViewHolder(binding: ItemSuggestBinding) : RecyclerView.ViewHolder(binding.root) {
        val logo = binding.ivLogo
        val content = binding.tvContent
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            ItemSuggestBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder

        Glide.with(context).load(listItem[position].logo).into(viewHolder.logo)
        viewHolder.content.text = listItem[position].content
    }

    override fun getItemCount(): Int {
        return listItem.size
    }
}