package com.example.projetoespacoculturalunifor

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SalonsPage : AppCompatActivity() {

    private lateinit var btnSettings: ImageButton;
    private lateinit var btnQr: ImageButton;
    private lateinit var btnHome: ImageButton;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.salons_page)

        btnSettings = findViewById(R.id.settingsButton);
        btnQr = findViewById(R.id.qrButton);
        btnHome = findViewById(R.id.homeButton);

        btnSettings.setOnClickListener {
            changeScreen(this, SettingsPage::class.java);
        }

        btnHome.setOnClickListener {
            changeScreen(this, HomePage::class.java);
        }

    }

    private fun Context.changeScreen(activity: Activity, classs:Class<*>?){
        val intent = Intent(activity, classs);
        startActivity(intent);
        activity.overridePendingTransition(0, 0); // Definindo nenhuma animação
        activity.finish();
    }
}