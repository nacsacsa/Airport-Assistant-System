package com.example.searchapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    lateinit var usernameInput : EditText
    lateinit var passwordInput : EditText
    lateinit var loginButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        usernameInput = findViewById(R.id.input_username)
        passwordInput = findViewById(R.id.input_password)
        loginButton = findViewById(R.id.button_login)

        loginButton.setOnClickListener{
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()
            if (isPasswordGood(username, password)) {
                Log.i("Login attempt", "Success");
                startActivity(Intent(this, SearchActivity::class.java))
                finish()
            }
            else {
                Log.i("Login attempt", "Fail");
                Toast.makeText(this, "Invalid login credentials.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isPasswordGood(username : String, password : String): Boolean {
        return username == "user" && password == "pass";
    }
}