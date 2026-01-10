package com.example.searchapp

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlinx.serialization.Serializable
import java.net.HttpURLConnection
import java.net.URL

class SearchActivity : AppCompatActivity() {

    @Serializable
    data class Data(
        val latitude: String,
        val longitude: String
    )

    lateinit var spinner : Spinner
    lateinit var searchButton : Button
    //var url  = "https://geodb-free-service.wirefreethought.com/v1/geo/places?limit=1&offset=0&types=CITY&namePrefix=Budapest&sort=-population"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_search)

        searchButton = findViewById(R.id.button_submit)

        var url  = "https://geodb-free-service.wirefreethought.com/v1/geo/places?limit=1&offset=0&types=CITY&namePrefix=Budapest&sort=-population"
        val items = listOf("Budapest", "Szeged", "Debrecen", "Győr", "Miskolc")
        spinner = findViewById(R.id.spinner_options)
        val adapter = ArrayAdapter(
            this,
            R.layout.spinner_item,
            items
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        searchButton.setOnClickListener{
            Thread {
                val json = httpGet(url)
                Log.i("JSON answer", json)
            }.start()
        }
    }

    fun httpGet(urlString: String) : String {
        val url = URL(urlString)
        val conn = url.openConnection() as HttpURLConnection
        conn.requestMethod = "GET"
        conn.connectTimeout = 5000
        conn.readTimeout = 5000
        val response = conn.inputStream.bufferedReader().use { it.readText() }
        conn.disconnect()
        return  response
    }
}