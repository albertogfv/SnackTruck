package com.albertogfv.snacktruck.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.albertogfv.snacktruck.data.db.entities.OrderItem

@Dao
interface OrderDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: OrderItem)

    @Delete
    suspend fun delete(item: OrderItem)

    @Query("Select * FROM order_items")
    fun getAllOrderItems(): LiveData<List<OrderItem>>

    @Query("Select * FROM order_items")
    fun getAllVegOrderItems(): LiveData<List<OrderItem>>

    @Query("Select * FROM order_items")
    fun getAllNonVegOrderItems(): LiveData<List<OrderItem>>



}