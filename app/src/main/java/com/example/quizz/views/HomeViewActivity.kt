package com.example.quizz.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizz.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home_view.*

class HomeViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_view)
        bindViews()
        bindListeners()
    }
    private fun bindViews(){
        val welcome = user_view.text.toString()
        user_view.text = welcome + FirebaseAuth.getInstance().currentUser!!.email.toString()
    }

    private fun bindListeners(){

    }
}
