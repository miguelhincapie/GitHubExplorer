package com.mac.githubexplorer.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.mac.githubexplorer.R
import com.mac.githubexplorer.presentation.model.Data
import com.mac.githubexplorer.presentation.model.RecyclerViewType
import com.mac.githubexplorer.presentation.model.Status
import com.mac.githubexplorer.presentation.model.utils.observe
import com.mac.githubexplorer.presentation.presenter.viewmodel.FeedListViewModel
import com.mac.githubexplorer.presentation.presenter.viewmodel.FeedListViewModelFactory
import com.mac.githubexplorer.presentation.ui.adapters.FeedAdapter
import com.mac.githubexplorer.presentation.ui.adapters.FeedDelegateAdapter
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class FeedActivity : AppCompatActivity(), FeedDelegateAdapter.OnFeedItemListListener {

    @Inject
    lateinit var feedViewModelFactory: FeedListViewModelFactory
    private lateinit var feedListViewModel: FeedListViewModel

    private lateinit var adapter: FeedAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar?.setCustomView(R.layout.feed_abs_layout)

        AndroidInjection.inject(this)

        adapter = FeedAdapter(this)
        feed_list.adapter = adapter

        feedListViewModel =
            ViewModelProviders.of(this, feedViewModelFactory).get(FeedListViewModel::class.java)

        feedListViewModel.getFeedElementsLiveData().observe(this) { onFeedListChanged(it) }

        whatsOnYourMindButton.setOnClickListener {
            run {
                startActivity(Intent(this, CreatePostActivity::class.java))
            }
        }

        feedListViewModel.getFeedList()
    }

    private fun onFeedListChanged(response: Data<List<RecyclerViewType>>) {
        when (response.responseType) {
            Status.ERROR -> {
                Log.d("asdf", "onError")
            }
            Status.LOADING -> {
                //Progress
            }
            Status.SUCCESSFUL -> {
                Log.d("asdf", "onSuccessful")
                response.data?.let {
                    adapter.setElements(it as MutableList<RecyclerViewType>)
                }
            }
        }
    }

    override fun onImageClicked() {
        // TODO implement it
    }
}
