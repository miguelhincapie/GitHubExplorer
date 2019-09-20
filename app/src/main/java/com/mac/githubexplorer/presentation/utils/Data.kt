package com.mac.githubexplorer.presentation.utils

data class Data<RequestData>(
    var responseType: Status,
    var data: RequestData? = null,
    var error: String? = null
)

enum class Status { SUCCESSFUL, ERROR, LOADING }