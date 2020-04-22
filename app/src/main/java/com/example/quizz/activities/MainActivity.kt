package com.example.quizz.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizz.R
import com.example.quizz.authentication.LoginActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        transition()
    }
    private fun transition(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}
