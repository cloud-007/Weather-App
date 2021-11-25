package com.example.weatherapplicaion

import android.content.Intent
import android.content.SharedPreferences
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapplicaion.Adapter.CityAdapter
import com.example.weatherapplicaion.Adapter.RecyclerAdapter
import com.example.weatherapplicaion.databinding.WeatherLayoutBinding
import org.json.JSONObject
import java.net.URL
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {


    lateinit var sharedPref: SharedPreferences

    var City = "Sylhet"


    val API = "10ecbd0b45f88595d55e77eb9121920b"

    var isOn: Boolean = true
    lateinit var searchText: String

    lateinit var binding: WeatherLayoutBinding

    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        City = sharedPref.getString("City", "Sylhet").toString()
        binding = WeatherLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = RecyclerAdapter()
        binding.recyclerView.adapter = adapter
        weatherTask().execute()

        binding.btnMore.setOnClickListener {
            Toast.makeText(this, "Coming soon...", Toast.LENGTH_SHORT).show()
        }

        binding.iconHamburger.setOnClickListener {
            Toast.makeText(this, "Coming soon...", Toast.LENGTH_SHORT).show()
        }

        binding.iconAdd.setOnClickListener {
            val clicking = Intent(this@MainActivity, SearchActivity::class.java)
            startActivity(clicking)
        }
    }

    override fun onResume() {
        super.onResume()
        City = sharedPref.getString("City", "Sylhet").toString()
        weatherTask().execute()
    }

    inner class weatherTask() : AsyncTask<String, Void, String>() {
        override fun onPreExecute() {
            super.onPreExecute()
            binding.progressBar.visibility = View.VISIBLE
            binding.containerMain.visibility = View.GONE
        }

        override fun doInBackground(vararg params: String?): String? {
            var response: String?
            try {
                response =
                    URL("https://api.openweathermap.org/data/2.5/weather?q=$City&units=metric&appid=$API")
                        .readText(Charsets.UTF_8)

            } catch (e: Exception) {
                response = null
            }
            return response
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            try {
                val jsonObj = JSONObject(result)
                val main = jsonObj.getJSONObject("main")
                val sys = jsonObj.getJSONObject("sys")
                val wind = jsonObj.getJSONObject("wind")
                val weather = jsonObj.getJSONArray("weather").getJSONObject(0)
                val updatedAt: Long = jsonObj.getLong("dt")
                val updatedAtText =
                    "Updated at: " + SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH).format(
                        Date(updatedAt * 1000)
                    )
                val tempMin = main.getString("temp_min") + "°C"
                val tempMax = main.getString("temp_max") + "°C"
                val weatherDescription = weather.getString("description")
                val address = jsonObj.getString("name") + ", " + sys.getString("country")

                val str = main.getString("temp")
                val temp = str.dropLast(3) + "°"

                binding.tvLocation.text = address
                binding.tvUpdatedAt.text = updatedAtText
                binding.tvDescription.text = weatherDescription.capitalize()
                binding.tvTemp.text = temp
                binding.tvMaxMin.text = tempMax + "/" + tempMin

                binding.progressBar.visibility = View.GONE
                binding.tvErrorText.visibility = View.GONE
                binding.containerMain.visibility = View.VISIBLE

            } catch (e: Exception) {
                // binding.tvErrorText.visibility = View.VISIBLE
            }
        }

    }

}