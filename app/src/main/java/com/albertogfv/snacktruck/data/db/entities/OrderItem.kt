package com.albertogfv.snacktruck.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "order_items")
data class OrderItem(
    @ColumnInfo(name = "item_name")
    var name: String,

    @ColumnInfo(name = "isVeggie")
    var isVeggie: Boolean,

    @ColumnInfo(name = "amount")
    var amount: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

}

