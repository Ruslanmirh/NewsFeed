package ru.mirkhusainov.newsfeed.features.news

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_news.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.mirkhusainov.newsfeed.R
import ru.mirkhusainov.newsfeed.core.base.BaseFragment
import ru.mirkhusainov.newsfeed.core.di.Scopes
import ru.mirkhusainov.newsfeed.features.news.model.ArticleItem
import toothpick.Toothpick

class NewsFragment : BaseFragment(), NewsView {
    override val layoutRes: Int = R.layout.fragment_news

    lateinit var adapter: NewsAdapter

    @InjectPresenter
    lateinit var presenter: NewsPresenter

    @ProvidePresenter
    fun providePresenter(): NewsPresenter =
        Toothpick.openScopes(Scopes.SCOPE_APP, scopeName).getInstance(NewsPresenter::class.java)

    override fun onInit(savedInstanceState: Bundle?) {

        adapter = NewsAdapter()
        rvNewsList.layoutManager = LinearLayoutManager(requireContext())
        rvNewsList.adapter = adapter
    }


    override fun updateArticles(articles: List<ArticleItem>) {
        adapter.articleList = articles
    }

    companion object {
        fun getInstance() = NewsFragment()
    }
}