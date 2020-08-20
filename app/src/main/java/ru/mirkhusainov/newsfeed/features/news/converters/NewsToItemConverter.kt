package ru.mirkhusainov.newsfeed.features.news.converters

import ru.mirkhusainov.newsfeed.data.network.model.Article
import ru.mirkhusainov.newsfeed.features.news.model.ArticleItem
import javax.inject.Inject

class NewsToItemConverter @Inject constructor() {
    fun convert(article: Article) = ArticleItem(
        title = article.title,
        sourceName = article.source.name,
        imageUrl = article.urlToImage,
        url = article.url
    )
}