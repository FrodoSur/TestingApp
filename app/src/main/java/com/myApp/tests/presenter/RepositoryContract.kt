package com.myApp.tests.presenter

import com.myApp.tests.model.SearchResponse
import com.myApp.tests.repository.RepositoryCallback

interface RepositoryContract {
    fun searchGithub(
        query: String,
        callback: RepositoryCallback
    )

    suspend fun searchGithubAsync(
        query: String
    ): SearchResponse
}
