package com.rezara.advancecourse2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_items.view.*

class Recycleradapter (
    val names: List<String>,
    val clickListener:(String)->Unit
) :
    RecyclerView.Adapter<Recycleradapter.RecyclerViewHolderKotlinClass>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewHolderKotlinClass {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_items, parent, false)
        return RecyclerViewHolderKotlinClass(v, clickListener)
    }

    override fun getItemCount() = names.size

    override fun onBindViewHolder(holder: RecyclerViewHolderKotlinClass, position: Int) =
        holder.onBind(names[position])


    class RecyclerViewHolderKotlinClass(
        val item: View,
        val clickListener:(String)->Unit
    ) : RecyclerView.ViewHolder(item) {
        fun onBind(name: String) {
            item.txtname.text = name
            item.setOnClickListener {
                clickListener(name)
            }


        }
    }
}
