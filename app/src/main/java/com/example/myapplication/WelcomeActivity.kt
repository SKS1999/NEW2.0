package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {
    private lateinit var btnlogin: Button
    private lateinit var btnsignup: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)







            btnlogin =findViewById(R.id.login_button_welcome)
            btnsignup = findViewById(R.id.signup_button_welcome)


            btnsignup.setOnClickListener {
                val intent = Intent(this,RegisterActivity::class.java)
                startActivity(intent)
            }
            btnlogin.setOnClickListener {
                val intent = Intent(this,LoginActivity::class.java)
                startActivity(intent)
            }

    }

    }
