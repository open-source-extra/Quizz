package com.example.quizz.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizz.R

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_acitivty)
        transition()
    }
    private fun transition(){
        val intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
    }
}
