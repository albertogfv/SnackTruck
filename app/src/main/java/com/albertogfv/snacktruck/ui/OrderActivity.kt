package com.albertogfv.snacktruck.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.albertogfv.snacktruck.R
import com.albertogfv.snacktruck.data.db.OrderDatabase
import com.albertogfv.snacktruck.data.repositories.OrderRepository
import com.albertogfv.snacktruck.ui.OrderList.OrderViewModel
import com.albertogfv.snacktruck.ui.OrderList.OrderViewModelFactory

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val database = OrderDatabase(this)
        val repository = OrderRepository(database)
        val factory = OrderViewModelFactory(repository)

        val viewModel = ViewModelProviders.of(this, factory).get(OrderViewModel::class.java)
    }
}