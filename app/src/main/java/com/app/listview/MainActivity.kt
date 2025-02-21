package com.app.listview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.List)

        var countryList = resources.getStringArray(R.array.countries)// Define the list of countries

        var arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, countryList)// Create an ArrayAdapter to bind the list to the ListView
        listView.adapter = arrayAdapter// Bind the adapter to the ListView

        listView.setOnItemClickListener { parent, view, position, id ->
            parent.getItemAtPosition(position).toString()
            val countryName:String = parent.getItemAtPosition(position).toString()
            Toast.makeText(applicationContext, "You selected $countryName", Toast.LENGTH_SHORT).show()


        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.List)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}