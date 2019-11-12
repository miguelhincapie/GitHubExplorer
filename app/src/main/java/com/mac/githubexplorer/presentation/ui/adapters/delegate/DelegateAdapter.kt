package com.mac.githubexplorer.presentation.ui.adapters.delegate

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mac.githubexplorer.presentation.model.RecyclerViewType

interface DelegateAdapter<VH : RecyclerView.ViewHolder, VT : RecyclerViewType> {

    fun onCreateViewHolder(parent: ViewGroup): VH
    fun onBindViewHolder(viewHolder: VH, viewType: VT)
}