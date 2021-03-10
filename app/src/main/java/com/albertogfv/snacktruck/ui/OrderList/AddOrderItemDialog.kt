package com.albertogfv.snacktruck.ui.OrderList

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.albertogfv.snacktruck.R
import com.albertogfv.snacktruck.data.db.entities.OrderItem
import kotlinx.android.synthetic.main.dialog_add_order_item.*

class AddOrderItemDialog (context: Context, var addDialogListener: AddDialogListener): AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_order_item)
        tvAdd.setOnClickListener {
            val name = etName.text.toString()
            val amount = etAmount.text.toString()

            if (name.isEmpty() || amount.isEmpty()) {
                Toast.makeText(context, "Please enter all the information", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            val item = OrderItem(name, true, amount.toInt())
            addDialogListener.addButtonClicked(item)
            dismiss()

            tvCancel.setOnClickListener{
                cancel()
            }
        }
    }
}