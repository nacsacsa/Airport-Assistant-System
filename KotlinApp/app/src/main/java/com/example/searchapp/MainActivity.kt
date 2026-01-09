package com.example.searchapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var usernameInput : EditText
    lateinit var passwordInput : EditText
    lateinit var loginButton : Button

    private fun isPasswordGood(username : String, password : String): Boolean {
        return username == "user" && password == "pass";
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        usernameInput = findViewById(R.id.input_username)
        passwordInput = findViewById(R.id.input_password)
        loginButton = findViewById(R.id.button_login)

        loginButton.setOnClickListener{
            val username = usernameInput.text.toString();
            val password = passwordInput.text.toString();
            if (isPasswordGood(username, password)) {
                Log.i("Login attempt", "Siker");
            }
            else {
                Log.i("Login attempt", "Fail");
            }
        }
    }
}