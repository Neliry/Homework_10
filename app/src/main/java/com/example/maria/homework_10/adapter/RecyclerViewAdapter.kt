package com.example.maria.homework_10.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.maria.homework_10.R
import kotlinx.android.synthetic.main.list_item.view.*

class RecyclerViewAdapter(private val mDataSet: Array<Pair<String, String>>, private var context: Context?) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private var listener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView = view.textView!!

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (listener != null && position != RecyclerView.NO_POSITION) {
                    listener!!.onItemClick(position)
                }
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerViewAdapter.ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.list_item, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
        holder.textView.text = mDataSet[position].first
    }

    override fun getItemCount(): Int {
        return mDataSet.size
    }

    companion object {
        private val TAG = "CustomAdapter"
    }
}