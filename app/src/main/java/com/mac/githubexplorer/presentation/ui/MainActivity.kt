package com.mac.githubexplorer.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.mac.githubexplorer.R
import com.mac.githubexplorer.domain.entities.Repo
import com.mac.githubexplorer.presentation.model.Data
import com.mac.githubexplorer.presentation.model.Status
import com.mac.githubexplorer.presentation.model.utils.observe
import com.mac.githubexplorer.presentation.presenter.viewmodel.ReposViewModel
import com.mac.githubexplorer.presentation.presenter.viewmodel.ReposViewModelFactory
import com.mac.githubexplorer.presentation.ui.adapters.RepoListAdapter
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), RepoListAdapter.GitHubRepoListListener {

    @Inject
    lateinit var reposViewModelFactory: ReposViewModelFactory

    private lateinit var adapter: RepoListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AndroidInjection.inject(this)

        adapter = RepoListAdapter(this)
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

    /**
     * Just for some checks with Dagger, the stack of view is being cleaned.
     * There isn't any validation cuz is out of the scope of this guide.
     */
    override fun onRepoSelected(repo: Repo) {
        intent = Intent(this, RepoDetailActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val bundle = Bundle()
        bundle.putString(USER_NAME, repo.owner) // TODO working on modify DTO in order to get repo owner
        bundle.putString(REPO_NAME, repo.name)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}
