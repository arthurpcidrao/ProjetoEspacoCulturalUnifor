package com.example.projetoespacoculturalunifor

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class ArtsPage1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.arts_page)

        val returnButton = findViewById<ConstraintLayout>(R.id.returnButton);
        val btnArt1 = findViewById<LinearLayout>(R.id.s1a1);

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