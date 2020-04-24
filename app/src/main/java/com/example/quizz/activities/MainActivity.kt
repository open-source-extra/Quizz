package com.example.quizz.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizz.R
import com.example.quizz.authentication.LoginActivity
import com.example.quizz.views.HomeViewActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkUserStatus()
    }
    private fun transition(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
    private fun checkUserStatus(){
        if (FirebaseAuth.getInstance().currentUser == null){
            transition()
        }
        else{
            val intent = Intent(this,HomeViewActivity::class.java)
            startActivity(intent)
        }
    }
}
