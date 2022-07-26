package com.example.bloodsugartracking9d.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bloodsugartracking9d.R

class Custom_dialog_adapter() : RecyclerView.Adapter<Custom_dialog_adapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.measurement_layout_adapter, parent, false)

        return Custom_dialog_adapter.MyViewHolder(view)
    }

    class MyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {


        val radio_btn: RadioButton = itemView.findViewById(R.id.radio_btn)
        val textView: TextView = itemView.findViewById(R.id.textView)


    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }


}