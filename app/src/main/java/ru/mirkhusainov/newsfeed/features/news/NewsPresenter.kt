package ru.mirkhusainov.newsfeed.features.news

import moxy.InjectViewState
import ru.mirkhusainov.newsfeed.core.base.BasePresenter
import ru.mirkhusainov.newsfeed.data.network.model.NewsResponse
import ru.mirkhusainov.newsfeed.domain.NewsRepository
import ru.mirkhusainov.newsfeed.features.news.converters.NewsToItemConverter
import ru.mirkhusainov.newsfeed.utils.extensions.async
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class NewsPresenter @Inject constructor(
    private val newsRepository: NewsRepository,
    private val router: Router,
    private val newsToItemConverter: NewsToItemConverter
) : BasePresenter<NewsView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        newsRepository.getNewsAboutAndroid(1)
            .async()
            .subscribe { response: NewsResponse ->
                viewState.updateArticles(response.articles.map(newsToItemConverter::convert))
            }
            .addViewLifeCycle()
    }
}