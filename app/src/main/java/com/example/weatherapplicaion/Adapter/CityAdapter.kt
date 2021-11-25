package com.example.weatherapplicaion.Adapter

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapplicaion.Data.DataSourceCity
import com.example.weatherapplicaion.MainActivity
import com.example.weatherapplicaion.R
import kotlinx.android.synthetic.main.example_city.view.*
import org.w3c.dom.Text

class CityAdapter() : RecyclerView.Adapter<CityAdapter.ViewHolder>(
) {

    lateinit var context: Context
    lateinit var listener: Listener
    fun setProperties(context: Context, listener: Listener) {
        this.context = context
        this.listener = listener
    }

    interface Listener {
        fun onItemSelected(
            city: String
        )
    }

    private val item = DataSourceCity.createDataSet()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.example_city, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tvCity.text = item[position].city
        holder.itemView.tvCountry.text = item[position].country
        holder.itemView.setOnClickListener {
            // Toast.makeText(context, "Coming soon...", Toast.LENGTH_SHORT).show()
            listener.onItemSelected(item[position].city + ", " + item[position].country)
        }
    }

    override fun getItemCount(): Int {
        return item.size
    }

    inner class ViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView)

}