package com.example.projetoespacoculturalunifor

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class HomePage : AppCompatActivity() {

    private lateinit var btnSettings: ImageButton;
    private lateinit var btnQr: ImageButton;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.home_page)

        btnSettings = findViewById(R.id.settingsButton);

        btnSettings.setOnClickListener {
            changeScreen(this, SettingsPage::class.java);
        }
    }

    private fun Context.changeScreen(activity: Activity, classs:Class<*>?){
        val intent = Intent(activity, classs);
        startActivity(intent);
        activity.finish();
    }
}