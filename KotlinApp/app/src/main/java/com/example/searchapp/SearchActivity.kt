package com.example.searchapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
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
    data class GeoResponse(
        val data: List<City>
    )

    @Serializable
    data class City(
        val name: String,
        val latitude: Double,
        val longitude: Double
    )

    lateinit var spinner : Spinner
    lateinit var searchButton : Button

    var baseUrl = "https://geodb-free-service.wirefreethought.com/v1/geo/places?limit=1&offset=0&types=CITY&sort=-population&namePrefix="
    val items = listOf("Budapest", "Szeged", "Debrecen", "Győr", "Miskolc")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_search)

        searchButton = findViewById(R.id.button_submit)
        spinner = findViewById(R.id.spinner_options)
        val adapter = ArrayAdapter(
            this,
            R.layout.spinner_item,
            items
        )
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
            val json = httpGet(url)
            val response : GeoResponse = parseData(json)
            val city = response.data.first()
            val latitude = city.latitude
            val longitude = city.longitude
            runOnUiThread {
                val uri = java.lang.String.format(
                    Locale.ENGLISH,
                    "geo:%f,%f?q=%f,%f", latitude, longitude, latitude, longitude
                )
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
                startActivity(intent)
            }
        }.start()
    }

    fun httpGet(urlString: String) : String {
        val url = URL(urlString)
        val connection = url.openConnection() as HttpURLConnection
        connection.requestMethod = "GET"
        connection.connectTimeout = 5000
        connection.readTimeout = 5000
        val response = connection.inputStream.bufferedReader().use { it.readText() }
        connection.disconnect()
        return response
    }

    inline fun <reified T> parseData(json: String) : T {
        val jsonParser = Json {
            ignoreUnknownKeys = true
        }
        val response = jsonParser.decodeFromString<T>(json)
        return response
    }
}