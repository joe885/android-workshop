package com.warpwood.workshopapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.warpwood.workshopapp.databinding.FeedItemBinding

class FeedListAdapter: RecyclerView.Adapter<FeedListAdapter.ViewHolder>() {

    private val items: MutableList<FeedItem> = mutableListOf()

    fun setFeedItems(feedItems: List<FeedItem>) {
        items.clear()
        items.addAll(feedItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.feed_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding by lazy { FeedItemBinding.bind(itemView) }

        fun bind(feedItem: FeedItem) {
            binding.itemTitle.text = feedItem.title
        }
    }
}