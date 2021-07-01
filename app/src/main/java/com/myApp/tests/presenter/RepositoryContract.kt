package com.myApp.tests.presenter

import com.myApp.tests.repository.RepositoryCallback

internal interface RepositoryContract {
    fun searchGithub(
        query: String,
        callback: RepositoryCallback
    )
}
