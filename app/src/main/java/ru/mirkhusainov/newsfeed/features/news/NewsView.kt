package ru.mirkhusainov.newsfeed.features.news

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import ru.mirkhusainov.newsfeed.features.news.model.ArticleItem

interface NewsView : MvpView {
    @AddToEndSingle
    fun updateArticles(articles: List<ArticleItem>)
}