package com.example.projetoespacoculturalunifor

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetoespacoculturalunifor.models.Salons
import com.google.android.material.imageview.ShapeableImageView

class SalonsAdapter(private val salonsList: List<Salons>) :
    RecyclerView.Adapter<SalonsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.main_line_view, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentSalon = salonsList[position]
        holder.nameTextView.text = currentSalon.name

        // Configurando a imagem no ShapeableImageView
        holder.imageView.setImageResource(currentSalon.image)
    }

    override fun getItemCount(): Int {
        return salonsList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.name)
        val imageView: ImageView = itemView.findViewById(R.id.image)
    }
}