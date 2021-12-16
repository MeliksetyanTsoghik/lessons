package com.example.lesson1.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.lesson1.R
import com.example.lesson1.User
import com.example.lesson1.addUser

class RegisterActivity : AppCompatActivity() {

    private var errorT: TextView? = null

// todo add url field
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registr)

        initViews()
        initListeners()
    }

    private fun initListeners() {
        findViewById<Button>(R.id.registerButton).setOnClickListener {
            register()
        }
    }
    private fun initViews() {
        errorT = findViewById (R.id.errorText)
    }

    private fun register() {
        val mail = findViewById<EditText>(R.id.mailEditText).text.toString()
        val login = findViewById<EditText>(R.id.loginEditText).text.toString()
        val password = findViewById<EditText>(R.id.passwordEditText).text.toString()
        val imageUrl = findViewById<EditText>(R.id.imageUrlEditText).text.toString()



        if (isValidFields(mail, login, password,imageUrl
            )) {
            val isUserAdded = addUser(User(mail, login, password,imageUrl))
            if (isUserAdded) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
               showError("We already have such user ")
            }
        }
    }


    private fun isValidFields(mail: String, login: String, password: String, imageUrl : String): Boolean {

        if (mail.isEmpty() || login.isEmpty() || password.isEmpty()  )  {
            showError("All fields must be completed")
            return false
        }
         if (password.length < 6) {
             showError("Password should be 6 symbols")
             return false
         }
        errorT?.visibility = View.GONE
        return true
    }

    private fun showError(message: String) {
        errorT?.visibility = View.VISIBLE
        errorT?.text = message
    }


}






