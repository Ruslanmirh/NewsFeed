package ru.mirkhusainov.newsfeed.core.navigation

import ru.mirkhusainov.newsfeed.features.news.NewsFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object SplashScreen : SupportAppScreen()
class NewsScreen : SupportAppScreen() {
    override fun getFragment() = NewsFragment.getInstance()
}

object WebScreen : SupportAppScreen()
