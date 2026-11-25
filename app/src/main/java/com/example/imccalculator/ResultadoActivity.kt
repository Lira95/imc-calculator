package com.example.imccalculator

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(Color.TRANSPARENT)
        )
        setContentView(R.layout.activity_resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, 0, systemBars.right, systemBars.bottom)
            insets
        }

        val txtImc = findViewById<TextView>(R.id.txtImc)
        val txtClassificacao = findViewById<TextView>(R.id.txtClassificacao)

        val imc = intent.getDoubleExtra("IMC", 0.0)
        val classificacao = if (imc <18.5) {
            "ABAIXO DO PESO"
            } else if (imc < 25){
                "NORMAL"
            } else if (imc < 30){
            "SOBREPESO"
            } else if (imc < 35){
            "OBESIDADE GRAU I"
            } else if (imc < 40){
            "OBESIDADE GRAU II"
            } else{
            "OBESIDADE GRAU III"
        }

        txtImc.text = String.format(Locale.US, "%.2f", imc)
        txtClassificacao.text = classificacao
    }
}