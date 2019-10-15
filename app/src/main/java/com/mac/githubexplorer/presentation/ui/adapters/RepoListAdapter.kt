package com.mac.githubexplorer.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mac.githubexplorer.R
import com.mac.githubexplorer.domain.entities.Repo
import kotlinx.android.synthetic.main.github_repo_item.view.*


class RepoListAdapter(private val listListener: GitHubRepoListListener) :
    RecyclerView.Adapter<RepoListAdapter.GitHubRepoViewHolder>() {
    var gitHubRepos = mutableListOf<Repo>()
        set(value) {
            field.clear()
            field.addAll(value)
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitHubRepoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.github_repo_item, parent, false)
        return GitHubRepoViewHolder(view, listListener)
    }

    override fun getItemCount() = gitHubRepos.size

    override fun onBindViewHolder(holder: GitHubRepoViewHolder, position: Int) {
        holder.bind(gitHubRepos[position])
    }

    class GitHubRepoViewHolder(itemView: View, private val listListener: GitHubRepoListListener) : RecyclerView.ViewHolder(itemView) {

        fun bind(repo: Repo) {
            with(itemView) {
                repoName.text = repo.name
                repoDescription.text = repo.description
                repoLanguage.text =
                    String.format(
                        context.getString(R.string.language),
                        repo.language
                    )
                repoPrivate.text =
                    String.format(
                        context.getString(R.string.stars),
                        repo.stargazersCount
                    )
                setOnClickListener { listListener.onRepoSelected(repo) }
            }
        }
    }

    interface GitHubRepoListListener {
        fun onRepoSelected(repo: Repo)
    }
}