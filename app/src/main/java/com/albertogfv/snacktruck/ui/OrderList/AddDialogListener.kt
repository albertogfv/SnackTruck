package com.albertogfv.snacktruck.ui.OrderList

import com.albertogfv.snacktruck.data.db.entities.OrderItem

interface AddDialogListener {
    fun addButtonClicked(item: OrderItem)
}