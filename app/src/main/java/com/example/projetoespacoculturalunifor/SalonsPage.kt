package com.example.projetoespacoculturalunifor

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.projetoespacoculturalunifor.models.Salons

class SalonsPage : AppCompatActivity() {

    private lateinit var btnSettings: Button;
    private lateinit var btnQr: Button;
    private lateinit var btnHome: Button;

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SalonsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.salons_page)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val salonsList = getListOfSalons()
        adapter = SalonsAdapter(salonsList)
        recyclerView.adapter = adapter

        btnSettings = findViewById(R.id.settingsButton);
        btnQr = findViewById(R.id.qrButton);
        btnHome = findViewById(R.id.homeButton);

        btnSettings.setOnClickListener {
            Global.expoA = false;
            changeScreenWt(this, SettingsPage::class.java);
        }

        btnHome.setOnClickListener {
            Global.expoA = false;
            changeScreenWt(this, HomePage::class.java);
        }

        btnQr.setOnClickListener {
            Global.expoA = false;
            changeScreenWt(this, QrPage::class.java);
        }


        val btnAdd = findViewById<ConstraintLayout>(R.id.btn_add);
        val btnOptions = findViewById<ConstraintLayout>(R.id.optionsButton);
        val miniTela = findViewById<RelativeLayout>(R.id.idSalon);
        val toolbar = findViewById<LinearLayout>(R.id.gerenciamento);

        miniTela.visibility = View.GONE;

        if (Global.adm){
            btnAdd.visibility = View.VISIBLE;
            btnOptions.visibility = View.VISIBLE;
        }
        else{
            btnAdd.visibility = View.GONE;
            btnOptions.visibility = View.GONE;
        }

        btnAdd.setOnClickListener {
            btnAdd.visibility = View.GONE;
            miniTela.visibility = View.VISIBLE;
            toolbar.visibility = View.GONE;
        }



        val addSalon = findViewById<Button>(R.id.addSalon);

        addSalon.setOnClickListener {

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

    private fun getListOfSalons(): List<Salons> {
        // Aqui você deve retornar a lista de objetos Salons com os dados do seu banco de dados ou de onde quer que venham os dados
        // Por enquanto, vamos retornar uma lista de exemplos
        val list = mutableListOf<Salons>()

        if (Global.expoA){
            list.add(Salons(1,"antiga 1", R.drawable.salao1))
            list.add(Salons(2,"antiga 2", R.drawable.salao2))
            list.add(Salons(3,"antiga 3", R.drawable.salao3))
        }
        else{
            list.add(Salons(1,"Salão 1", R.drawable.salao1))
            list.add(Salons(2,"Salão 2", R.drawable.salao2))
            list.add(Salons(3,"Salão 3", R.drawable.salao3))
        }

        // Adicione mais salões conforme necessário
        return list
    }
}