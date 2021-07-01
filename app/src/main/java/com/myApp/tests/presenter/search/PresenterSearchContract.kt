package com.myApp.tests.presenter.search

import com.myApp.tests.presenter.PresenterContract

internal interface PresenterSearchContract : PresenterContract {
    fun searchGitHub(searchQuery: String)
}
