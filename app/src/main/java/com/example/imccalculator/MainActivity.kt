package com.example.imccalculator

import android.os.Bundle
import android.graphics.Color
import android.widget.Button
import android.widget.Toast
import android.content.Intent
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import java.util.Locale
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()  //instala e ativa a splash e depois troca para o tema normal do app
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
                statusBarStyle = SystemBarStyle.dark(Color.TRANSPARENT)
            )

        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, 0, systemBars.right, systemBars.bottom)
            insets
        }

        // Encontra as peças da tela
        val edtPeso = findViewById<TextInputEditText>(R.id.edtPeso)
        val edtAltura = findViewById<TextInputEditText>(R.id.edtAltura)
        val btnCalcular = findViewById<Button>(R.id.btn_calcular)

        // Açao ao clicar no Botao
        btnCalcular.setOnClickListener {
            val peso = edtPeso.text.toString().replace("," , ".").toDoubleOrNull()
            val altura = edtAltura.text.toString().replace("," , ".").toDoubleOrNull()

            if (peso == null || altura == null || peso <= 0 || altura <= 0) {
                Toast.makeText(this, "Preencha peso e altura corretamente", Toast.LENGTH_SHORT).show()
            } else {
                val imc = peso / (altura * altura)
                val intent = Intent(this, ResultadoActivity::class.java)
                intent.putExtra("IMC", imc)
                startActivity(intent)
            }
    }
        }
}