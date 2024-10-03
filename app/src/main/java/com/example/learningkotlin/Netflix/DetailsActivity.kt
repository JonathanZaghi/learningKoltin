package com.example.learningkotlin.Netflix

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.learningkotlin.R

class DetailsActivity : AppCompatActivity() {

    lateinit var buttonFechar: Button
    lateinit var textFilm: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalhes)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        buttonFechar = findViewById(R.id.button_fechar)
        textFilm = findViewById(R.id.textFilm)

        val bundle = intent.extras

        if(bundle != null) {
            val filme = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                bundle.getSerializable("film", Film::class.java)
            } else {
                bundle.getSerializable("film") as? Film
            }
            textFilm.text = "$filme"
        }

        buttonFechar.setOnClickListener {
            val resultIntent = Intent()

            // Adicionando dados ao Intent (Exemplo: uma String)
            resultIntent.putExtra("result_key", "Resultado retornado da OutraActivity")

            // Definindo o resultado como RESULT_OK e passando o Intent
            setResult(Activity.RESULT_OK, resultIntent)

            // Finalizando a OutraActivity para retornar o resultado
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("ciclo_vida", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("ciclo_vida", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("ciclo_vida", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("ciclo_vida", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("ciclo_vida", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("ciclo_vida", "onDestroy")
    }
}