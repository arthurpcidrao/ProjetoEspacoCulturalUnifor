package com.example.projetoespacoculturalunifor

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SettingsPage : AppCompatActivity(){

    private lateinit var btnHome: ImageButton;
    private lateinit var btnCompass: ImageButton;
    private lateinit var btnQr: ImageButton;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.settings_page)

        val meuSpinner = findViewById<Spinner>(R.id.languagesSpinner)
        val opcoes = arrayOf("Português", "English", "Español");
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, opcoes);

        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        meuSpinner.adapter = adaptador

        val supportVisibility = findViewById<LinearLayout>(R.id.supportVisibility)
        val supportButton = findViewById<ImageButton>(R.id.supportButton)
        var on: Boolean = true

        btnHome = findViewById(R.id.homeButton);
        btnCompass = findViewById(R.id.compassButton);
        btnQr = findViewById(R.id.qrButton);

        supportButton.setOnClickListener{
            if (on) {
                val novaImagem = resources.getDrawable(R.drawable.arrow_down)
                supportVisibility.visibility = View.GONE
                supportButton.setImageDrawable(novaImagem)
                on = !on
            } else {
                //val novaImagem = resources.getDrawable(R.drawable.arrow_right)
                //supportVisibility.visibility = View.VISIBLE
                //supportButton.setImageDrawable(novaImagem)
                //on = !on
            }
        }

        btnHome.setOnClickListener {
            changeScreen(this, HomePage::class.java);
        }

        btnCompass.setOnClickListener {
            changeScreen(this, SalonsPage::class.java)
        }
    }

    private fun Context.changeScreen(activity: Activity, classs:Class<*>?){
        val intent = Intent(activity, classs);
        startActivity(intent);
        activity.overridePendingTransition(0, 0); // Definindo nenhuma animação
        activity.finish();
    }
}