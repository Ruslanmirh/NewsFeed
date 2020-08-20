package ru.mirkhusainov.newsfeed.features.main

import moxy.InjectViewState
import ru.mirkhusainov.newsfeed.core.base.BasePresenter
import ru.mirkhusainov.newsfeed.core.navigation.NewsScreen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(private val router: Router) : BasePresenter<MainView>() {

    fun openHomeScreen() = router.navigateTo(NewsScreen())
}