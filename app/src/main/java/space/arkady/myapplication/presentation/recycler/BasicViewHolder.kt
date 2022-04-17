package space.arkady.myapplication.presentation.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import space.arkady.myapplication.domain.models.BaseItem

abstract class BasicViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    abstract fun bindItem(item: BaseItem)
}