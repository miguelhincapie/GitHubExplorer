package com.mac.githubexplorer

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class GitHubExplorerApp @Inject constructor() : Application()