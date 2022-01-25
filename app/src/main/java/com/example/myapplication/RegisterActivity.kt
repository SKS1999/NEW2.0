package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        signup_button.setOnClickListener {
       val email = email_register.text.toString()
       val password = password_register.text.toString()


            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "invalid email or password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

        Log.d("RegisterActivity","Email is :"+email)
        Log.d("RegisterActivity","Password is: $password")

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                if (!it.isSuccessful) return@addOnCompleteListener

                Log.d("Main", "Successfully created user with uid: ${it.result.user!!.uid}")
            }
            .addOnFailureListener {
                Log.d("Main", "Faild to create user: ${it.message}")
            }

          }
        Already_have_an_account_register.setOnClickListener {

            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
        login_button_signup.setOnClickListener {
            val intent1 = Intent(this,LoginActivity :: class.java)
             startActivity(intent1)

        }
        signup_button_signup.setOnClickListener {
            val intent2 = Intent(this,RegisterActivity::class.java)
            startActivity(intent2)
        }
    }
}