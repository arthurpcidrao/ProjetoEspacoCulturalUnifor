package com.example.projetoespacoculturalunifor

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class SettingsPage : AppCompatActivity(){

    private lateinit var btnHome: ImageButton;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_page)

        btnHome = findViewById(R.id.homeButton);

        btnHome.setOnClickListener {
            changeScreen(this, HomePage::class.java);
        }
    }

    private fun Context.changeScreen(activity: Activity, classs:Class<*>?){
        val intent = Intent(activity, classs);
        startActivity(intent);
        activity.finish();
    }
}