package com.example.projetoespacoculturalunifor

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ArtsPage1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.arts_page)

        val returnButton = findViewById<Button>(R.id.returnButton);
        val btnArt1: LinearLayout = findViewById(R.id.s1a1);

        btnArt1.setOnClickListener{
            changeScreen(this, ArtInfoPage::class.java);
        }

        returnButton.setOnClickListener {
            changeScreen(this, SalonsPage::class.java)
        }

    }

    private fun changeScreen(activity: Activity, clasS: Class<*>?) {
        val intent = Intent(activity, clasS)
        startActivity(intent)
        activity.finish()
    }
}