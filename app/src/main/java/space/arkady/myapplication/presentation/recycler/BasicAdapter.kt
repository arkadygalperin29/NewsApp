package space.arkady.myapplication.presentation.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import space.arkady.myapplication.domain.models.BaseItem
import space.arkady.myapplication.domain.models.Date
import space.arkady.myapplication.domain.models.News
import space.arkady.myapplication.presentation.recycler.clickListener.OnItemClickListener
import space.arkady.myapplication.presentation.recycler.interfaceviewholders.DateViewHolder
import space.arkady.myapplication.presentation.recycler.interfaceviewholders.NewsViewHolder
import java.lang.IllegalStateException

class BasicAdapter(private val clickListener: OnItemClickListener) :
    RecyclerView.Adapter<BasicViewHolder>() {

    private var items: List<BaseItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasicViewHolder {
        return when (viewType) {
            DateViewHolder.VIEW_TYPE -> DateViewHolder.newInstance(parent)
            NewsViewHolder.VIEW_TYPE -> NewsViewHolder.newInstance(parent, clickListener)
            else -> throw IllegalStateException("UnExisting viewHolder")
        }
    }

    override fun onBindViewHolder(holder: BasicViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is Date -> DateViewHolder.VIEW_TYPE
            is News -> NewsViewHolder.VIEW_TYPE
        }
    }

    override fun getItemCount(): Int = items.size

    fun submitList(data: List<BaseItem>) {
        items = data
        notifyDataSetChanged()
    }
}