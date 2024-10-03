package com.example.learningkotlin.BMI

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.learningkotlin.R

class ResultBMIActivity : AppCompatActivity() {

    private lateinit var typedWeight: TextView
    private lateinit var typedHeight: TextView
    private lateinit var resultBMI: TextView
    private lateinit var resultBMINumber: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result_bmiactivity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        typedWeight = findViewById(R.id.typed_weight)
        typedHeight = findViewById(R.id.typed_height)
        resultBMI = findViewById(R.id.result_bmi)
        resultBMINumber = findViewById(R.id.bmi_number)

        val bundle = intent.extras
        if(bundle != null) {
            val weight = bundle.getDouble("weight")
            val height = bundle.getDouble("height")

            typedHeight.text = getString(R.string.reported_height, height)
            typedWeight.text = getString(R.string.reported_weight, weight)

            val bmi = weight / (height * height)

            resultBMINumber.text = String.format("Diagnotic %.2f", bmi)

            resultBMI.text = if (bmi < 18.5) {
                 "Baixo"
            } else if (bmi in 18.5..24.9) {
                 "Normal"
            } else if (bmi in 25.0..29.9) {
               "sobrepeso"
            } else {
                "Obeso"
            }
        }
    }
}