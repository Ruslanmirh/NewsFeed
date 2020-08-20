package ru.mirkhusainov.newsfeed.features.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_article.view.*
import ru.mirkhusainov.newsfeed.R
import ru.mirkhusainov.newsfeed.features.news.model.ArticleItem
import ru.mirkhusainov.newsfeed.utils.extensions.loadFromUrl

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {

    var articleList: List<ArticleItem> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false)
        return ArticleViewHolder(view)
    }

    override fun getItemCount() = articleList.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(articleList[position])
    }

    class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(articleItem: ArticleItem) {
            with(itemView) {
                tvArticleTitle.text = articleItem.title
                tvArticleSource.text = articleItem.sourceName
                articleItem.imageUrl?.let {
                    ivArticleImage.loadFromUrl(it)
                }
            }
        }
    }

}