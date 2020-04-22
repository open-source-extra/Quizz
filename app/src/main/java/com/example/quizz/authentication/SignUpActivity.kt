package com.example.quizz.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quizz.R
import com.example.quizz.views.HomeViewActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_up_acitivty.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_acitivty)
        bindListeners()
    }
    private fun bindListeners(){
        goto_login.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

        signup_button.setOnClickListener {
            val email = signup_mail.text.toString()
            val password = signup_password.text.toString()
            val confirm = confirm_password.text.toString()

            val error = verifyInputs(email, password, confirm)
            if (error != ""){
                Toast.makeText(this,error,Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            signUp(email,password)
        }

    }

    fun verifyInputs(email:String,password:String,confirm:String):String {
        if (email.isEmpty() || password.isEmpty() || confirm.isEmpty()) {
            return "Fill up the fields properly"
        }
        else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return "Not a valid email address"
        }
        else if (!password.equals(confirm)){
            return "Passwords do not match"
        }
        return ""
    }

    fun signUp(email:String,password: String){
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
            .addOnSuccessListener {
                Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show()
                val intent = Intent(this,HomeViewActivity::class.java)
                startActivity(intent)
                return@addOnSuccessListener
        }
        return
    }

}
