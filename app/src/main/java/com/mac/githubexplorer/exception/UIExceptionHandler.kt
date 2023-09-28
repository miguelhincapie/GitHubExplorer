package com.mac.githubexplorer.exception

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

interface UIExceptionHandler {

    val errorState: MutableStateFlow<String?>
    val handler: CoroutineExceptionHandler
}

fun ViewModel.launchWithExceptionHandler(
    context: CoroutineContext = Dispatchers.IO,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
): Job {
    return viewModelScope.launch(
        getCoroutineExceptionHandler()?.let { context + it } ?: context,
        start,
        block
    )
}

private fun ViewModel.getCoroutineExceptionHandler(): CoroutineExceptionHandler? {
    return (this as? UIExceptionHandler)?.handler
}