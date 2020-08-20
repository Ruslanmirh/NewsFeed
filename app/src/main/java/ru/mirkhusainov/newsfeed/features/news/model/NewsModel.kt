package ru.mirkhusainov.newsfeed.features.news.model

data class ArticleItem(
    val title: String,
    val sourceName: String,
    val imageUrl: String?,
    val url: String
)