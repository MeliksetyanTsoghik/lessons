package com.example.lesson1.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.lesson1.R
import com.example.lesson1.haveSuchUser

class LoginActivity : AppCompatActivity(){
    var errorTextView : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initViews()
        setListeners()
        signUpListener()
    }

    private fun initViews() {
        errorTextView = findViewById(R.id.errorTextView)
    }

    private fun setListeners() {
        findViewById<Button>(R.id.signInButton).setOnClickListener{
            if(isValidCredentials()){
                errorTextView?.visibility = View.INVISIBLE
                login()
            } else {
                errorTextView?.visibility = View.VISIBLE
            }
        }
    }

   private fun isValidCredentials() : Boolean {
        val enteredLogin = findViewById<EditText>(R.id.loginEditText).text.toString()
        val enteredPassword = findViewById<EditText>(R.id.passwordEditText).text.toString()
        return haveSuchUser(enteredLogin, enteredPassword)
    }

    private fun login() {
        val intent = Intent (this, MainActivity::class.java)
        startActivity(intent)

    }

    private fun signUpListener (){
        findViewById<Button>(R.id.signUpButton).setOnClickListener {
            signUp()
        }
    }

    private fun signUp () {

        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
}