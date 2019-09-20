package com.mac.githubexplorer.presentation.views

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.mac.githubexplorer.R
import com.mac.githubexplorer.domain.entities.Repo
import com.mac.githubexplorer.presentation.App
import com.mac.githubexplorer.presentation.utils.Data
import com.mac.githubexplorer.presentation.utils.Status
import com.mac.githubexplorer.presentation.utils.observe
import com.mac.githubexplorer.presentation.viewmodels.ReposViewModel
import com.mac.githubexplorer.presentation.viewmodels.ReposViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var reposViewModelFactory: ReposViewModelFactory

    private lateinit var adapter: GitHubRepoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as App).getMainActivityComponent().inject(this)

        adapter = GitHubRepoAdapter()
        list_view_repos.adapter = adapter

        val reposViewModel =
            ViewModelProviders.of(this, reposViewModelFactory).get(ReposViewModel::class.java)
        reposViewModel.getStarredRepositoriesLiveData()
            .observe(this) { onStarredRepositoriesChanged(it) }

        button_search.setOnClickListener {
            run {
                val username = edit_text_username.text.toString()
                if (!TextUtils.isEmpty(username)) {
                    reposViewModel.fetchStarredRepositories(username)
                }
            }
        }

        button_gotoanotheractivity.setOnClickListener {
            run { startActivity(Intent(this, Activity2::class.java)) }
        }
    }

    private fun onStarredRepositoriesChanged(response: Data<List<Repo>>) {
        when (response.responseType) {
            Status.ERROR -> {
                //Error handling
            }
            Status.LOADING -> {
                //Progress
            }
            Status.SUCCESSFUL -> {
                adapter.gitHubRepos = response.data as MutableList<Repo>
            }
        }
    }
}
