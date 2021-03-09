package com.albertogfv.snacktruck.ui.OrderList

import androidx.lifecycle.ViewModel
import com.albertogfv.snacktruck.data.db.entities.OrderItem
import com.albertogfv.snacktruck.data.repositories.OrderRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OrderViewModel (
    private val repository: OrderRepository
): ViewModel() {

    fun upsert(item: OrderItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: OrderItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllOrderItems()  = repository.getAllOrderItems()

    fun getVegOrderItems() = repository.getVegOrderItems()

    fun getNoVegOrderItems() = repository.getNoVegOrderItems()
}