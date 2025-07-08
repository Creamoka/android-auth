package com.example.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.content.Intent
import com.google.firebase.auth.FirebaseAuth

class DefaultActivity : AppCompatActivity() {

    private lateinit var loginButton: Button
    private lateinit var registerButton: Button
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.defaultactivity)

        mAuth = FirebaseAuth.getInstance()

        loginButton = findViewById(R.id.loginButton)
        registerButton = findViewById(R.id.registerButton)

        loginButton.setOnClickListener {
            startActivity(Intent(this@DefaultActivity, LoginActivity::class.java))
        }

        registerButton.setOnClickListener {
            startActivity(Intent(this@DefaultActivity, RegisterActivity::class.java))
        }

        checkUserSession()
    }

    private fun checkUserSession() {
        val currentUser = mAuth.currentUser
        if (currentUser != null) {
            startActivity(Intent(this@DefaultActivity, MainActivity::class.java))
            finish() // Close this activity
        }
    }
}
