package com.albertogfv.snacktruck.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.albertogfv.snacktruck.R
import com.albertogfv.snacktruck.data.db.entities.OrderItem
import com.albertogfv.snacktruck.ui.OrderList.OrderViewModel
import kotlinx.android.synthetic.main.order_item.view.*

class OrderItemAdapter(
    var items: List<OrderItem>,
    private val viewModel: OrderViewModel
) : RecyclerView.Adapter<OrderItemAdapter.OrderViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OrderItemAdapter.OrderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.order_item, parent, false)
        return OrderViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: OrderItemAdapter.OrderViewHolder, position: Int) {
        val curOrderItem = items[position]

        holder.itemView.tvName.text =  curOrderItem.name
        holder.itemView.tvAmount.text = "${curOrderItem.amount}"

        holder.itemView.ivDelete.setOnClickListener {
            viewModel.delete(curOrderItem)
        }

        holder.itemView.ivPlus.setOnClickListener {
            curOrderItem.amount++
            viewModel.upsert(curOrderItem
            )
        }

        holder.itemView.ivMinus.setOnClickListener {
            if(curOrderItem.amount > 0) {
                curOrderItem.amount--
                viewModel.upsert(curOrderItem)
            }
        }

    }

    inner class OrderViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}