package com.example.projetoespacoculturalunifor

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class SalonsPage : AppCompatActivity() {

    private lateinit var btnSettings: Button;
    private lateinit var btnQr: Button;
    private lateinit var btnHome: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.salons_page)

        val btnSalon1: LinearLayout = findViewById(R.id.salao1)
        val btnSalon2: LinearLayout = findViewById(R.id.salao2)
        val btnSalon3: LinearLayout = findViewById(R.id.salao3)
        val btnSalon4: LinearLayout = findViewById(R.id.salao4)

        val btnAdd = findViewById<ConstraintLayout>(R.id.btn_add);
        val btnOptions = findViewById<ConstraintLayout>(R.id.optionsButton);

        if (Global.adm){
            btnAdd.visibility = View.VISIBLE;
            btnOptions.visibility = View.VISIBLE;
        }
        else{
            btnAdd.visibility = View.GONE;
            btnOptions.visibility = View.GONE;
        }

        btnSettings = findViewById(R.id.settingsButton);
        btnQr = findViewById(R.id.qrButton);
        btnHome = findViewById(R.id.homeButton);

        btnSettings.setOnClickListener {
            changeScreenWt(this, SettingsPage::class.java);
        }

        btnHome.setOnClickListener {
            changeScreenWt(this, HomePage::class.java);
        }

        btnSalon1.setOnClickListener{
            changeScreen(this, ArtsPage1::class.java);
        }
        btnSalon2.setOnClickListener{
            changeScreen(this, ArtsPage1::class.java);
        }
        btnSalon3.setOnClickListener{
            changeScreen(this, ArtsPage1::class.java);
        }
        btnSalon4.setOnClickListener{
            changeScreen(this, ArtsPage1::class.java);
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