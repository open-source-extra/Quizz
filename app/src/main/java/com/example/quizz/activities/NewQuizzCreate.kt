package com.example.quizz.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.quizz.R
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_new_quizz_create.*

class NewQuizzCreate : AppCompatActivity() {

    private lateinit var privacyButton : RadioButton
    var privacy: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_quizz_create)
        bindListeners()
    }

    private fun bindListeners(){
        set_exam.setOnClickListener {
            val quizName = exam_name.text.toString()
            val id = radio_privacy.checkedRadioButtonId
            FirebaseDatabase.getInstance().reference.setValue(privacy)


        }
        radio_privacy.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener{group ,checkedId ->
                val radio:RadioButton = findViewById(checkedId)
                privacy = radio.text.toString()
                print(privacy)

            }

        )
    }
}
