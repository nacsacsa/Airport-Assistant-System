package com.example.searchapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.net.HttpURLConnection
import java.net.URL
import java.util.Locale


class SearchActivity : AppCompatActivity() {

    @Serializable
    data class Coordinate(
        val latitude: Double,
        val longitude: Double
    )

    private lateinit var spinner : Spinner
    private lateinit var searchButton : Button

    private var baseUrl = "http://10.0.2.2:8080/api/cities?city="
    private val items = listOf("Budapest", "Szeged", "Debrecen", "Győr", "Miskolc")
    private var token = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_search)
        val token = intent.getStringExtra("TOKEN")!!
        this.token = token
        searchButton = findViewById(R.id.button_submit)
        spinner = findViewById(R.id.spinner_options)
        val adapter = ArrayAdapter(this, R.layout.spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        searchButton.setOnClickListener{
            searchActiveCity()
        }
    }

    private fun searchActiveCity() {
        val selectedCity = spinner.selectedItem.toString()
        val url = baseUrl + selectedCity
        Thread {
            val json = getCoordinatesFromApi(url, token)
            Log.i("Json", json)
            val response : Coordinate = parseData(json)
            val latitude = response.latitude
            val longitude = response.longitude
            runOnUiThread {
                val uri = java.lang.String.format(Locale.ENGLISH, "geo:%f,%f?q=%f,%f", latitude, longitude, latitude, longitude)
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
                startActivity(intent)
            }
        }.start()
    }

    private fun getCoordinatesFromApi(urlString: String, token: String) : String {
        val url = URL(urlString)
        val connection = url.openConnection() as HttpURLConnection
        connection.requestMethod = "GET"
        connection.connectTimeout = 5000
        connection.readTimeout = 5000
        connection.setRequestProperty("Authorization", "Bearer $token")
        val response = connection.inputStream.bufferedReader().use { it.readText() }
        connection.disconnect()
        return response
    }

    inline fun <reified T> parseData(json: String) : T {
        val jsonParser = Json { ignoreUnknownKeys = true }
        val response = jsonParser.decodeFromString<T>(json)
        return response
    }
}