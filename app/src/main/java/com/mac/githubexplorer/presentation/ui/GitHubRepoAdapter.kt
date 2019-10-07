package com.mac.githubexplorer.presentation.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mac.githubexplorer.R
import com.mac.githubexplorer.domain.entities.Repo
import kotlinx.android.synthetic.main.github_repo_item.view.*


class GitHubRepoAdapter : RecyclerView.Adapter<GitHubRepoAdapter.GitHubRepoViewHolder>() {
    var gitHubRepos = mutableListOf<Repo>()
        set(value) {
            field.clear()
            field.addAll(value)
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitHubRepoViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.github_repo_item, parent, false)
        return GitHubRepoViewHolder(
            view
        )
    }

    override fun getItemCount() = gitHubRepos.size

    override fun onBindViewHolder(holder: GitHubRepoViewHolder, position: Int) {
        holder.bind(gitHubRepos[position])
    }

    class GitHubRepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(repo: Repo) {
            with(itemView) {
                text_repo_name.text = repo.name
                text_repo_description.text = repo.description
                text_language.text =
                    String.format(
                        context.getString(R.string.language),
                        repo.language
                    )
                text_stars.text =
                    String.format(
                        context.getString(R.string.stars),
                        repo.stargazersCount
                    )
            }
        }
    }
}