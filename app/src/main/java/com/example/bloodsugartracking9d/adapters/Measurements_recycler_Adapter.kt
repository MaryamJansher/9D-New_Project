package com.example.bloodsugartracking9d.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bloodsugartracking9d.R

class Measurements_recycler_Adapter(private val value_list: List<Int>) :
    RecyclerView.Adapter<Measurements_recycler_Adapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.measurements_adapter, parent, false)

        return Measurements_recycler_Adapter.MyViewHolder(view)


    }


    class MyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {


        val textView: TextView = itemView.findViewById(R.id.tv_measurements)


    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.textView.text = value_list[position].toString()


    }


    override fun getItemCount(): Int {

        return value_list.size
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

}
