package com.albertogfv.snacktruck.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.albertogfv.snacktruck.R
import com.albertogfv.snacktruck.data.db.OrderDatabase
import com.albertogfv.snacktruck.data.db.entities.OrderItem
import com.albertogfv.snacktruck.data.repositories.OrderRepository
import com.albertogfv.snacktruck.other.OrderItemAdapter
import com.albertogfv.snacktruck.ui.OrderList.AddDialogListener
import com.albertogfv.snacktruck.ui.OrderList.AddOrderItemDialog
import com.albertogfv.snacktruck.ui.OrderList.OrderViewModel
import com.albertogfv.snacktruck.ui.OrderList.OrderViewModelFactory
import kotlinx.android.synthetic.main.activity_order.*

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val database = OrderDatabase(this)
        val repository = OrderRepository(database)
        val factory = OrderViewModelFactory(repository)

        val viewModel = ViewModelProviders.of(this, factory).get(OrderViewModel::class.java)

        val adapter = OrderItemAdapter(listOf(), viewModel)

        rvOrderItems.layoutManager = LinearLayoutManager(this)
        rvOrderItems.adapter = adapter

        viewModel.getAllOrderItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        fab.setOnClickListener{
            AddOrderItemDialog( this,
                object : AddDialogListener {
                    override fun addButtonClicked(item: OrderItem) {
                        viewModel.upsert(item)
                    }
                }

            )
        }
    }
}