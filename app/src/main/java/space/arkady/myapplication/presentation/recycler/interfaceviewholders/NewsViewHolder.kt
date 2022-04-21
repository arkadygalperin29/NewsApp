package space.arkady.myapplication.presentation.recycler.interfaceviewholders

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.mirror_news.view.*
import space.arkady.myapplication.R
import space.arkady.myapplication.domain.models.BaseItem
import space.arkady.myapplication.domain.models.News
import space.arkady.myapplication.presentation.recycler.BasicViewHolder
import space.arkady.myapplication.presentation.recycler.clickListener.OnItemClickListener
import space.arkady.myapplication.utils.setImageByUrl

class NewsViewHolder(itemView: View, private val clickView: OnItemClickListener) :
    BasicViewHolder(itemView) {

    companion object {
        const val VIEW_TYPE = 2
        fun newInstance(parent: ViewGroup, clickView: OnItemClickListener) = NewsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.mirror_news, parent, false),
            clickView
        )
    }

    @SuppressLint("SetTextI18n")
    override fun bindItem(item: BaseItem) {
        (item as News).apply {
            itemView.textTitleNews.text = title
            itemView.descriptionNews.text = description
            itemView.textAuthorNews.text = "Author: $author"
            itemView.imageShare.setOnClickListener {
                articleUrl?.let { url -> clickView.onLinkButtonClickListener(url) }
            }
        }
    }
}