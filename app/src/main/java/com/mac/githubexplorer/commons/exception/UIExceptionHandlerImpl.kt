package com.mac.githubexplorer.commons.exception

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow

class UIExceptionHandlerImpl : UIExceptionHandler {

    override val errorState: MutableStateFlow<String?> = MutableStateFlow(null)
    override val handler: CoroutineExceptionHandler
        get() = CoroutineExceptionHandler { _, throwable ->
            errorState.value = throwable.message
        }
}