package com.example.projetoespacoculturalunifor

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

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