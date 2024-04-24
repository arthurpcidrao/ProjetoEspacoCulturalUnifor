package com.example.projetoespacoculturalunifor

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SalonsPage : AppCompatActivity() {

    private lateinit var btnSettings: Button;
    private lateinit var btnQr: Button;
    private lateinit var btnHome: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.salons_page)

        val btnSalon1: LinearLayout = findViewById(R.id.salao1)

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