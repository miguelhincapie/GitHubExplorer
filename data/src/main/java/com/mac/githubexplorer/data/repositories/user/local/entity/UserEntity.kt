package com.mac.githubexplorer.data.repositories.user.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
    @ColumnInfo("login")
    val login: String?,
    @PrimaryKey
    @ColumnInfo("id")
    val id: Int,
    @ColumnInfo("node_id")
    val nodeId: String?,
    @ColumnInfo("avatar_url")
    val avatarUrl: String?,
    @ColumnInfo("gravatar_id")
    val gravatarId: String?,
    @ColumnInfo("url")
    val url: String?,
    @ColumnInfo("html_url")
    val htmlUrl: String?,
    @ColumnInfo("followers_url")
    val followersUrl: String?,
    @ColumnInfo("following_url")
    val followingUrl: String?,
    @ColumnInfo("gists_url")
    val gistsUrl: String?,
    @ColumnInfo("starred_url")
    val starredUrl: String?,
    @ColumnInfo("subscriptions_url")
    val subscriptionsUrl: String?,
    @ColumnInfo("organizations_url")
    val organizationsUrl: String?,
    @ColumnInfo("repos_url")
    val reposUrl: String?,
    @ColumnInfo("events_url")
    val eventsUrl: String?,
    @ColumnInfo("received_events_url")
    val receivedEventsUrl: String?,
    @ColumnInfo("type")
    val type: String?,
    @ColumnInfo("site_admin")
    val siteAdmin: Boolean?,
    @ColumnInfo("name")
    val name: String?,
    @ColumnInfo("company")
    val company: String?,
    @ColumnInfo("blog")
    val blog: String?,
    @ColumnInfo("location")
    val location: String?,
    @ColumnInfo("email")
    val email: String?,
    @ColumnInfo("hireable")
    val hireable: Boolean?,
    @ColumnInfo("bio")
    val bio: String?,
    @ColumnInfo("twitter_username")
    val twitterUsername: String?,
    @ColumnInfo("public_repos")
    val publicRepos: Int?,
    @ColumnInfo("public_gists")
    val publicGists: Int?,
    @ColumnInfo("followers")
    val followers: Int?,
    @ColumnInfo("following")
    val following: Int?,
    @ColumnInfo("created_at")
    val createdAt: String?,
    @ColumnInfo("updated_at")
    val updatedAt: String?
)
