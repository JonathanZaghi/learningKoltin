package com.example.learningkotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.learningkotlin.BMI.MainBMIActivity
import com.example.learningkotlin.Netflix.DetailsActivity
import com.example.learningkotlin.Netflix.Film

class MainActivity : AppCompatActivity() {

    lateinit var buttonNetflix: Button
    lateinit var buttonIMC: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        buttonNetflix = findViewById(R.id.button_abrir)
        buttonIMC = findViewById(R.id.button_imc)


        buttonNetflix.setOnClickListener {
            val intent = Intent(this, DetailsActivity::class.java)
            val film = Film(
                name = "The Witcher",
                description = "Geraldo killed cirila",
                distribution = "Netflix 2",
                evaluation = "9.2",
                director = "Jon Krasink"
            )

            intent.putExtra("film", film)
            startForResult.launch(intent)

        }

        buttonIMC.setOnClickListener {
            val intent = Intent(this, MainBMIActivity::class.java)
            startForResult.launch(intent)
        }

    }

    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
        }
    }

}