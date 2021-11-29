package com.example.weatherapplicaion

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapplicaion.Adapter.RecyclerAdapter
import com.example.weatherapplicaion.Model.jsonFile.weather
import com.example.weatherapplicaion.databinding.WeatherLayoutBinding
import com.example.weatherapplicaion.reposatory.Reposatory
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {


    lateinit var sharedPref: SharedPreferences
    private lateinit var viewModel: MainViewModel

    var City = "Sylhet"

    lateinit var binding: WeatherLayoutBinding

    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
    lateinit var rsp: weather

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        binding = WeatherLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // weatherTask().execute()
        executeTask()

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

    private fun executeTask() {
        val reposatory = Reposatory()
        val viewModelFactory = MainViewModelFactory(reposatory)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        viewModel.getData("https://api.openweathermap.org/data/2.5/weather?q=$City&units=metric&appid=10ecbd0b45f88595d55e77eb9121920b")

        sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        City = sharedPref.getString("City", "Sylhet").toString()

        adapter = RecyclerAdapter()
        binding.recyclerView.adapter = adapter

        viewModel.myResponse.observe(this, androidx.lifecycle.Observer { response ->
            rsp = response
            Log.d("Response", response.main.temp.toString())
            Log.d("Response", response.name)
            binding.tvLocation.text = response.name
            binding.tvTemp.text = response.main.temp.toString().dropLast(3) + "°C"
            binding.tvDescription.text = response.weather[0].description
            binding.tvFeelsLike.text = response.main.feels_like.toString() + "°C"
            binding.tvMaxMin.text = response.main.temp_max.toString()
                .dropLast(3) + "°C/" + response.main.temp_min.toString().dropLast(3) + "°C"
            val updatedAt: Long = response.dt.toLong()
            val updatedAtText =
                "Updated at: " + SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH).format(
                    Date(updatedAt * 1000)
                )
            binding.tvUpdatedAt.text = updatedAtText

            binding.progressBar.visibility = View.GONE
            binding.tvErrorText.visibility = View.GONE
            binding.containerMain.visibility = View.VISIBLE

        })
    }

    override fun onResume() {
        super.onResume()
        City = sharedPref.getString("City", "Sylhet").toString()
        executeTask()
    }

}
