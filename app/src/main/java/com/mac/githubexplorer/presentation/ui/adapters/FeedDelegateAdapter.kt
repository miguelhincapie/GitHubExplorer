package com.mac.githubexplorer.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mac.githubexplorer.R
import com.mac.githubexplorer.presentation.model.FeedItemViewType
import kotlinx.android.synthetic.main.feed_item.view.*

class FeedDelegateAdapter(private val feedListListener: OnFeedItemListListener) :
    DelegateAdapter<FeedDelegateAdapter.ViewHolder, FeedItemViewType> {

    interface OnFeedItemListListener {
        fun onImageClicked()
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        return ViewHolder(parent)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, viewType: FeedItemViewType) {
        viewHolder.bind(viewType, feedListListener)
    }

    class ViewHolder(viewGroup: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(viewGroup.context).inflate(
            R.layout.feed_item, viewGroup, false
        )
    ) {

        fun bind(feedItem: FeedItemViewType, listener: OnFeedItemListListener) {
            itemView.names.text =
                String.format("%1s %2s", feedItem.feed.first_name, feedItem.feed.last_name)
            itemView.date.text = feedItem.feed.unix_timestamp
            itemView.body.text = feedItem.feed.post_body
//            itemView.photo = feedItem.feed.image
            itemView.photo.setOnClickListener {
                listener.onImageClicked()
            }
        }
    }
}