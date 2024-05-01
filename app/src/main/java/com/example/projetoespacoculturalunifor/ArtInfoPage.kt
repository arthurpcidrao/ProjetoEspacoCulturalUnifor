package com.example.projetoespacoculturalunifor

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore


class ArtInfoPage : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.art_info_page)

        val progressBar = findViewById<ProgressBar>(R.id.loader)
        progressBar.visibility = View.VISIBLE

        val mainPage = findViewById<RelativeLayout>(R.id.mainContainer)
        mainPage.visibility = View.INVISIBLE


        val db = FirebaseFirestore.getInstance();
        val docRef = db.collection("obras").document("yo0ut5eFXpbxLvMn9ABN");

        val artName: TextView = findViewById(R.id.artName);
        val artAuthor: TextView = findViewById(R.id.artAuthor);
        val artDescription: TextView = findViewById(R.id.artDescription);

        docRef.get().addOnSuccessListener {
            if (it != null) {
                val name = it.data?.get("Nome da obra")?.toString();
                val year = it.data?.get("Ano")?.toString();
                val author = it.data?.get("Autor")?.toString();
                val description = it.data?.get("Descrição")?.toString();

                artName.text = "$name - $year";
                artAuthor.text = author;
                artDescription.text = description;

                mainPage.visibility = View.VISIBLE
                progressBar.visibility = View.INVISIBLE
            }
        }
            .addOnFailureListener{
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
                mainPage.visibility = View.INVISIBLE
                progressBar.visibility = View.VISIBLE
            }

        val returnButton = findViewById<Button>(R.id.returnButton)

        returnButton.setOnClickListener {
            changeScreen(this, ArtsPage1::class.java);
        }

        artAuthor.setOnClickListener {
            changeScreen(this, ArtistsInfoPage::class.java);
        }
    }

    private fun changeScreen(activity: Activity, clasS: Class<*>?) {
        val intent = Intent(activity, clasS)
        startActivity(intent)
        activity.finish()
    }
}