package com.example.quizz.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quizz.R
import com.example.quizz.activities.NewQuizzCreate
import com.example.quizz.authentication.LoginActivity
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
        logout_button.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            Toast.makeText(this,"Successfully logged out",Toast.LENGTH_SHORT).show()
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
        add_exam_button.setOnClickListener {
            val intent = Intent(this,NewQuizzCreate::class.java)
            startActivity(intent)
        }
    }
}
