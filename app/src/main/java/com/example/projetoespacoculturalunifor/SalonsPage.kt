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
        val btnSalon2: LinearLayout = findViewById(R.id.salao2)
        val btnSalon3: LinearLayout = findViewById(R.id.salao3)
        val btnSalon4: LinearLayout = findViewById(R.id.salao4)

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
            Global.salon = "1";
            changeScreen(this, ArtsPage1::class.java);
        }
        btnSalon2.setOnClickListener{
            Global.salon = "2";
            changeScreen(this, ArtsPage1::class.java);
        }
        btnSalon3.setOnClickListener{
            Global.salon = "3";
            changeScreen(this, ArtsPage1::class.java);
        }
        btnSalon4.setOnClickListener{
            Global.salon = "4";
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