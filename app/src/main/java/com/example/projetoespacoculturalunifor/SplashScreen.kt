package com.example.projetoespacoculturalunifor

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
//import java.util.logging.Handler
import android.os.Handler

class SplashScreen : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 1500 // Tempo de exibição da tela de abertura em milissegundos (2 segundos)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.splash_screen)

        Handler().postDelayed({
            // Este bloco será executado após o tempo definido acima
            // Aqui você pode iniciar sua atividade principal
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)

            // Fecha esta atividade para que o usuário não possa voltar para ela pressionando o botão "Voltar"
            finish()
        }, SPLASH_TIME_OUT)
    }
}