package com.example.listapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemListAdapter(private var items: List<ListItem>) : RecyclerView.Adapter<ItemListAdapter.ViewHolder>(), Filterable {

    private var filteredItems: List<ListItem> = items
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemListAdapter.ViewHolder, position: Int) {
        val images = listOf(
            R.drawable.image_1,
            R.drawable.image_2,
            R.drawable.image_3,
            R.drawable.image_4,
            R.drawable.image_5,
        )

        holder.title.text = filteredItems[position].title
        holder.subtitle.text = filteredItems[position].subtitle
        holder.itemImage.setImageResource(images.random())
    }

    override fun getItemCount() = filteredItems.size

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val query = constraint.toString()?.lowercase()
                filteredItems = if (query.isNullOrEmpty()) {
                    items
                } else {
                    items.filter {
                        it.title.lowercase().contains(query) || it.subtitle.lowercase().contains(query)
                    }
                }
                val filterResults = FilterResults()
                filterResults.values = filteredItems
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredItems = results?.values as List<ListItem>
                notifyDataSetChanged()
            }

        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title: TextView = itemView.findViewById(R.id.item_title)
        val subtitle: TextView = itemView.findViewById(R.id.item_subtitle)
        val itemImage: ImageView = itemView.findViewById(R.id.item_image)
    }
}