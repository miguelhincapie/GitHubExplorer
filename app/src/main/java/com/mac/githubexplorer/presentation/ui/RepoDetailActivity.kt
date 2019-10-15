package com.mac.githubexplorer.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.mac.githubexplorer.R
import com.mac.githubexplorer.domain.entities.RepoDetail
import com.mac.githubexplorer.presentation.model.Data
import com.mac.githubexplorer.presentation.model.Status
import com.mac.githubexplorer.presentation.model.utils.observe
import com.mac.githubexplorer.presentation.presenter.viewmodel.ReposViewModel
import com.mac.githubexplorer.presentation.presenter.viewmodel.ReposViewModelFactory
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.repo_detail_activity.*
import javax.inject.Inject

const val REPO_NAME = "repo_name_key"
const val USER_NAME = "user_name_key"

class RepoDetailActivity : AppCompatActivity() {

    @Inject
    lateinit var reposViewModelFactory: ReposViewModelFactory
    private lateinit var reposViewModel: ReposViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.repo_detail_activity)

        AndroidInjection.inject(this)

        reposViewModel =
            ViewModelProviders.of(this, reposViewModelFactory).get(ReposViewModel::class.java)

        intent.extras?.let {
            val userName = it.getString(USER_NAME)
            val repoName = it.getString(REPO_NAME)
            Log.d(TAG, userName)
            Log.d(TAG, repoName)
            if (userName.isNullOrEmpty() || repoName.isNullOrEmpty()) return

            reposViewModel.getRepoDetailsLiveData()
                .observe(this) { data -> onRepoDetailChanged(data) }
            reposViewModel.fetchRepositoryDetail(userName, repoName)
        }

        buttonPreviousActivity.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }

    private fun onRepoDetailChanged(response: Data<RepoDetail>) {
        when (response.responseType) {
            Status.ERROR -> {
                //Error handling
            }
            Status.LOADING -> {
                //Progress
            }
            Status.SUCCESSFUL -> {
                response.data?.let { bindRepoDetail(it) }
            }
        }
    }

    private fun bindRepoDetail(repoDetail: RepoDetail) {
        repoDetail.apply {
            repoName.text = name
            repoFullName.text = fullName
            repoDescription.text = description
            repoLanguage.text = language
            repoStargazerCount.text = stargazersCount.toString()
            repoPrivate.text = private.toString()
            repoCreatedAt.text = createdAt
            repoWatchersCount.text = watchersCount.toString()
            repoForks.text = forks.toString()
            repoOpenIssues.text = openIssues.toString()
            repoDefaultBranch.text = defaultBranch
        }
    }

    companion object {
        private val TAG = RepoDetailActivity::class.java.simpleName
    }
}
