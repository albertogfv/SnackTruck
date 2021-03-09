package com.albertogfv.snacktruck.ui.OrderList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.albertogfv.snacktruck.data.repositories.OrderRepository

class OrderViewModelFactory(
    private val repository: OrderRepository
): ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return OrderViewModel(repository) as T
    }
}