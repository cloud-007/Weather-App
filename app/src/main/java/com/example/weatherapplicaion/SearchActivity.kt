package com.example.weatherapplicaion

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapplicaion.Adapter.CityAdapter
import com.example.weatherapplicaion.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity(), CityAdapter.Listener {

    private lateinit var sharedPref: SharedPreferences

    private lateinit var binding: ActivitySearchBinding

    private var adapter: RecyclerView.Adapter<CityAdapter.ViewHolder>? = null

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val cityAdapter = CityAdapter()
        cityAdapter.setProperties(this, this)
        adapter = cityAdapter

        binding.recyclerViewCity.adapter = adapter

        binding.iconArrowBack.setOnClickListener {
            onBackPressed()
        }

        binding.iconMic.setOnClickListener {
            Toast.makeText(this, "Coming soon...", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onItemSelected(city: String) {
        val editor = sharedPref.edit()
        editor.putString("City", city).apply()
        finish()
    }
}