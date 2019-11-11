package com.mac.githubexplorer.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.mac.githubexplorer.R
import com.mac.githubexplorer.domain.entities.Repo
import com.mac.githubexplorer.presentation.model.Data
import com.mac.githubexplorer.presentation.model.Status
import com.mac.githubexplorer.presentation.model.utils.observe
import com.mac.githubexplorer.presentation.presenter.viewmodel.ReposViewModel
import com.mac.githubexplorer.presentation.presenter.viewmodel.ReposViewModelFactory
import com.mac.githubexplorer.presentation.ui.adapters.FeedAdapter
import com.mac.githubexplorer.presentation.ui.adapters.FeedDelegateAdapter
import com.mac.githubexplorer.presentation.ui.adapters.RepoListAdapter
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class FeedActivity : AppCompatActivity(), FeedDelegateAdapter.OnFeedItemListListener {

    @Inject
    lateinit var reposViewModelFactory: ReposViewModelFactory

    private lateinit var adapter: FeedAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar?.setCustomView(R.layout.feed_abs_layout)

        AndroidInjection.inject(this)

        adapter = FeedAdapter(this)
        feed_list.adapter = adapter

        val reposViewModel =
            ViewModelProviders.of(this, reposViewModelFactory).get(ReposViewModel::class.java)
        reposViewModel.getStarredRepositoriesLiveData()
            .observe(this) { onStarredRepositoriesChanged(it) }

        whatsonyourmindButton.setOnClickListener {
            run {
                Intent(this, CreatePostActivity::class.java)
                startActivity(intent)
            }
        }
    }

//    private fun onStarredRepositoriesChanged(response: Data<List<Repo>>) {
//        when (response.responseType) {
//            Status.ERROR -> {
//                //Error handling
//            }
//            Status.LOADING -> {
//                //Progress
//            }
//            Status.SUCCESSFUL -> {
//                adapter.gitHubRepos = response.data as MutableList<Repo>
//            }
//        }
//    }

    override fun onImageClicked() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
