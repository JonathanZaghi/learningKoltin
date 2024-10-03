package com.example.learningkotlin.BMI

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.learningkotlin.R

class MainBMIActivity : AppCompatActivity() {


    private lateinit var buttonCalculate: Button
    private lateinit var editWeight: EditText
    private lateinit var editHeight: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_bmi_activity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        buttonCalculate = findViewById(R.id.button_calculate_bmi)
        editHeight = findViewById(R.id.edit_height)
        editWeight = findViewById(R.id.edit_weight)
        buttonCalculate.setOnClickListener {
            val intent = Intent(this, ResultBMIActivity::class.java)
            val weight:String = editWeight.text.toString()
            val height:String = editHeight.text.toString()

            if(weight.isNotEmpty() && height.isNotEmpty()) {
                intent.putExtra("weight", weight.toDouble())
                intent.putExtra("height", height.toDouble())
            }

            startActivity(intent)
        }
    }
}