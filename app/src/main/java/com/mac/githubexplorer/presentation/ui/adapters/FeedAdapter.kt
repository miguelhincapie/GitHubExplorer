package com.mac.githubexplorer.presentation.ui.adapters

import androidx.collection.SparseArrayCompat
import com.mac.githubexplorer.presentation.model.FeedItemViewType
import com.mac.githubexplorer.presentation.model.utils.appendDelegate

class FeedAdapter(listener: FeedDelegateAdapter.OnFeedItemListListener): BaseAdapter() {
    init {
        delegateAdapters = SparseArrayCompat()
        delegateAdapters.appendDelegate(FeedItemViewType.FEED_ITEM.hashCode(), FeedDelegateAdapter(listener))
    }
}