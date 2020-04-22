package com.example.quizz.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quizz.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        bindListeners()
    }
    private fun bindListeners(){
        goto_signup.setOnClickListener {
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }
        login_button.setOnClickListener {
            val email = login_mail.text.toString()
            val password = login_password.text.toString()
            val error = verifyInputs(email,password)
            if (error != ""){
                Toast.makeText(this,error,Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            logIn(email,password)
        }

    }

    fun verifyInputs(email:String,password:String):String{
        if (email.isEmpty() || password.isEmpty()){
            return "Fill up the fields properly"
        }
        else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return "Not a valid email address"
        }
        return ""
    }

    fun logIn(email: String,password: String){
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password)
            .addOnSuccessListener {
                Toast.makeText(this,"Successfully Logged in",Toast.LENGTH_SHORT).show()
                return@addOnSuccessListener
            }
        return
    }


}
