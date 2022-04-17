package space.arkady.myapplication.presentation.recycler.interfaceviewholders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.mirror_date.view.*
import space.arkady.myapplication.R
import space.arkady.myapplication.domain.models.BaseItem
import space.arkady.myapplication.domain.models.Date
import space.arkady.myapplication.presentation.recycler.BasicViewHolder

class DateViewHolder(itemView: View) : BasicViewHolder(itemView) {

    companion object {
        const val VIEW_TYPE = 1
        fun newInstance(parent: ViewGroup) = DateViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.mirror_date, parent, false)
        )
    }

    override fun bindItem(item: BaseItem) {
        (item as Date).apply {
            itemView.textDate.text = item.dateNews.replace("-", ".")
        }
    }
}