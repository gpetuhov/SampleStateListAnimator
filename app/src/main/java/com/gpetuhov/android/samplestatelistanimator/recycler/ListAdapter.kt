package com.gpetuhov.android.samplestatelistanimator.recycler

import android.content.Context
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View


class ListAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val itemList = mutableListOf<String>()
    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = layoutInflater.inflate(android.R.layout.simple_list_item_1, parent, false)
        return ItemHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemHolder).bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun setList(quakeList: MutableList<String>) {
        this.itemList.clear()
        this.itemList.addAll(quakeList)
        notifyDataSetChanged()
    }

    // === ViewHolder ===

    private class ItemHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val itemTextView: TextView = itemView as TextView

        fun bind(item: String) {
            itemTextView.text = item
        }
    }
}
