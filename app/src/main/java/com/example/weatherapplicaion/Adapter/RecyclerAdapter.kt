package com.example.weatherapplicaion.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapplicaion.R

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private val item = DataSourceWeather.createDataSet()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.example_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.humidity.text = item[position].humidity
        holder.temp.text = item[position].temp
        holder.time.text = item[position].time
    }

    override fun getItemCount(): Int {
        return item.size
    }

    inner class ViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        var temp: TextView = itemView.findViewById(R.id.tv_Weather)
        var time: TextView
        var humidity: TextView

        init {
            time = itemView.findViewById(R.id.tvTime)
            humidity = itemView.findViewById(R.id.tvHumidity)
        }
    }

}