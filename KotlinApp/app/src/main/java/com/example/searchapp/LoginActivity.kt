package com.example.searchapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.net.HttpURLConnection
import java.net.URL

class LoginActivity : AppCompatActivity() {

    private lateinit var usernameInput : EditText
    private lateinit var passwordInput : EditText
    private lateinit var loginButton : Button
    private var loginURL = "http://10.0.2.2:8080/api/login"
    private var token : String = ""

    @Serializable
    data class User(
        val name: String,
        val password: String
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        usernameInput = findViewById(R.id.input_username)
        passwordInput = findViewById(R.id.input_password)
        loginButton = findViewById(R.id.button_login)

        loginButton.setOnClickListener{
            attemptLogin()
        }
    }

    private fun attemptLogin() {
        val username = usernameInput.text.toString()
        val password = passwordInput.text.toString()
        val user = User(username, password)
        Thread {
            val success = authenticateUser(loginURL, user)
            runOnUiThread {
                if (success) {
                    val intent = Intent(this, SearchActivity::class.java)
                    intent.putExtra("TOKEN", token)
                    startActivity(intent)
                    finish()
                }
                else {
                    Toast.makeText(this, "Invalid login credentials.", Toast.LENGTH_SHORT).show()
                }
            }
        }.start()
    }

    private fun authenticateUser(urlString: String, user : User) : Boolean {
        val url = URL(urlString)
        val connection = url.openConnection() as HttpURLConnection
        return try {
            connection.requestMethod = "POST"
            connection.connectTimeout = 5000
            connection.readTimeout = 5000
            connection.doOutput = true
            connection.setRequestProperty("Content-Type", "application/json")
            val jsonBody = Json.encodeToString(user)
            connection.outputStream.use { it.write(jsonBody.toByteArray()) }
            val responseCode = connection.responseCode
            if (responseCode == HttpURLConnection.HTTP_OK) {
                token = connection.inputStream.bufferedReader().readText()
                true
            } else {
                false
            }
        } finally {
            connection.disconnect()
        }
    }
}