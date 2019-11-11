package com.mac.githubexplorer.presentation.model.utils

import androidx.collection.SparseArrayCompat
import androidx.recyclerview.widget.RecyclerView
import com.mac.githubexplorer.presentation.model.RecyclerViewType
import com.mac.githubexplorer.presentation.ui.adapters.DelegateAdapter

@Suppress("UNCHECKED_CAST")
fun <E : DelegateAdapter<RecyclerView.ViewHolder, RecyclerViewType>> SparseArrayCompat<E>.appendDelegate(
    delegateId: Int,
    delegate: DelegateAdapter<out RecyclerView.ViewHolder, out RecyclerViewType>
) {
    this.append(delegateId, delegate as E)
}