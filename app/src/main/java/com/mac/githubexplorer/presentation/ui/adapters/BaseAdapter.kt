package com.mac.githubexplorer.presentation.ui.adapters

import android.view.ViewGroup
import androidx.collection.SparseArrayCompat
import androidx.recyclerview.widget.RecyclerView
import com.mac.githubexplorer.presentation.model.RecyclerViewType
import com.mac.githubexplorer.presentation.ui.adapters.delegate.DelegateAdapter

open class BaseAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items = mutableListOf<RecyclerViewType>()
    private set
    lateinit var delegateAdapters: SparseArrayCompat<DelegateAdapter<RecyclerView.ViewHolder, RecyclerViewType>>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegateAdapters[viewType]?.onCreateViewHolder(parent)!!
    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int) = items[position].getViewType()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        val delegateAdapter = delegateAdapters[item.getViewType()]
        delegateAdapter?.onBindViewHolder(holder, item)
    }

    open fun setElements(newListOfItems: MutableList<RecyclerViewType>) {
        items = newListOfItems
        notifyDataSetChanged()
    }
}