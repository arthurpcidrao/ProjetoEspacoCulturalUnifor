package com.example.projetoespacoculturalunifor

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class AdmLoginPage : AppCompatActivity() {
    var passwordVisible: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.adm_login_page)

        // Top Bar Buttons & Actions
        val returnButton = findViewById<Button>(R.id.returnButton)

        returnButton.setOnClickListener {
            changeScreen(this, SettingsPage::class.java)
        }


        // Screen Buttons & Actions
        val login = findViewById<EditText>(R.id.login)
        val password = findViewById<EditText>(R.id.password)
        val showPassword = findViewById<TextView>(R.id.showPasswordButton)
        showPassword.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG)

        showPassword.setOnClickListener {
            togglePasswordView(password)
        }

        val db = FirebaseFirestore.getInstance()
        val collectionRef = db.collection("adms")

        val btnAccess = findViewById<Button>(R.id.accessAdm);

        btnAccess.setOnClickListener {
            collectionRef.get().addOnSuccessListener {documents ->
                for (document in documents) {
                    val loginDb = document.getString("login")
                    val passwordDb = document.getString("senha")

                    if (login.text.toString() == loginDb && password.text.toString() == passwordDb){
                        Global.adm = true;
                        changeScreen(this, HomePage::class.java);
                        Toast.makeText(this, "Adm cadastrado", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }

                if (!Global.adm){
                    Toast.makeText(this, "Adm desconhecido", Toast.LENGTH_SHORT).show();
                }
            }
            .addOnFailureListener{
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
                Global.adm = false;
            }
        }

    }

    fun changeScreen(activity: Activity, clasS: Class<*>?) {
        val intent = Intent(activity, clasS)
        startActivity(intent)
        activity.finish()
    }

    fun togglePasswordView(view: EditText) {
        if (!passwordVisible) {
            view.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            passwordVisible = !passwordVisible
        } else {
            view.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            passwordVisible = !passwordVisible
        }
    }
}