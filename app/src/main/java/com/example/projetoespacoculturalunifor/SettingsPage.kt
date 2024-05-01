package com.example.projetoespacoculturalunifor

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class SettingsPage : AppCompatActivity(){

    private lateinit var btnHome: Button;
    private lateinit var btnCompass: Button;
    private lateinit var btnQr: Button;
    private lateinit var admButton: Button;

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

        admButton = findViewById(R.id.settingsAdmButton);
        btnHome = findViewById(R.id.homeButton);
        btnCompass = findViewById(R.id.compassButton);
        btnQr = findViewById(R.id.qrButton);

        val btnLogout = findViewById<ConstraintLayout>(R.id.btn_logout);

        if (Global.adm){
            admButton.visibility = View.GONE;
            btnLogout.visibility = View.VISIBLE;
        }
        else{
            admButton.visibility = View.VISIBLE;
            btnLogout.visibility = View.GONE;
        }

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

        btnLogout.setOnClickListener {
            changeScreen(this, HomePage::class.java);
            Global.adm = false;
            Toast.makeText(this, "saiu", Toast.LENGTH_SHORT).show();
        }

        btnHome.setOnClickListener {
            changeScreenWt(this, HomePage::class.java);
        }

        btnCompass.setOnClickListener {
            changeScreenWt(this, SalonsPage::class.java)
        }

        admButton.setOnClickListener{
            changeScreen(this, AdmLoginPage::class.java)
        }
    }

    private fun Context.changeScreenWt(activity: Activity, classs:Class<*>?){
        val intent = Intent(activity, classs);
        startActivity(intent);
        activity.overridePendingTransition(0, 0); // Definindo nenhuma animação
        activity.finish();
    }

    private fun Context.changeScreen(activity: Activity, classs:Class<*>?){
        val intent = Intent(activity, classs);
        startActivity(intent);
        activity.finish();
    }
}