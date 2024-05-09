package com.example.projetoespacoculturalunifor

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
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

        val excluir = findViewById<ImageView>(R.id.excluir);
        val editar = findViewById<ImageView>(R.id.editar);

        val cardEditar = findViewById<RelativeLayout>(R.id.card_editar)
        val cardExcluir = findViewById<RelativeLayout>(R.id.card_excluir)

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

        excluir.visibility = View.GONE;
        editar.visibility = View.GONE;

        btnOptions.setOnClickListener {
            excluir.visibility = View.VISIBLE;
            editar.visibility = View.VISIBLE;
        }

        excluir.setOnClickListener {
            cardExcluir.visibility = View.VISIBLE
        }

        editar.setOnClickListener {
            cardEditar.visibility = View.VISIBLE
        }


    }

    private fun changeScreen(activity: Activity, clasS: Class<*>?) {
        val intent = Intent(activity, clasS)
        startActivity(intent)
        activity.finish()
    }
}