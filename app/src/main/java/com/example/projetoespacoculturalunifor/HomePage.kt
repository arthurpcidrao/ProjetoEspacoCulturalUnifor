package com.example.projetoespacoculturalunifor

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class HomePage : AppCompatActivity() {

    private lateinit var btnSettings: Button;
    private lateinit var btnQr: Button;
    private lateinit var btnCompass: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.home_page)

        btnSettings = findViewById(R.id.settingsButton);
        btnQr = findViewById(R.id.qrButton);
        btnCompass = findViewById(R.id.compassButton);

        val btnArtistsInfoPage = findViewById<Button>(R.id.artistButton1);

        btnSettings.setOnClickListener {
            changeScreenWt(this, SettingsPage::class.java);
        }

        btnQr.setOnClickListener {
            changeScreenWt(this, QrPage::class.java);
        }

        btnCompass .setOnClickListener {
            changeScreenWt(this, SalonsPage::class.java);
        }

        btnArtistsInfoPage.setOnClickListener {
            changeScreen(this, ArtistsInfoPage::class.java);
        }
    }

    private fun Context.changeScreen(activity: Activity, classs:Class<*>?){
        val intent = Intent(activity, classs);
        startActivity(intent);
        activity.finish();
    }

    private fun Context.changeScreenWt(activity: Activity, classs:Class<*>?){
        val intent = Intent(activity, classs);
        startActivity(intent);
        activity.overridePendingTransition(0, 0); // Definindo nenhuma animação
        activity.finish();
    }
}