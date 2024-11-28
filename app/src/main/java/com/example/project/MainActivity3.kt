package com.example.project

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        // Liste pour stocker les objets Panier
        val listeP = mutableListOf<Panier>()

        // Récupération des vues
        val spinerC = findViewById<Spinner>(R.id.color)
        val spinerS = findViewById<Spinner>(R.id.size)
        val spinerQ = findViewById<Spinner>(R.id.quantite)
        val image = findViewById<ImageView>(R.id.imageP)
        val nam = findViewById<TextView>(R.id.nom)
        val prix = findViewById<TextView>(R.id.prix)
        val panier = findViewById<Button>(R.id.panier)

        // Récupération des données transmises via Intent
        val name = intent.getStringExtra("name")
        val price = intent.getStringExtra("price")
        val img = intent.getIntExtra("image", 0)

        // Définition des valeurs des spinners
        val colors = arrayOf("Color", "Red", "Green", "Black")
        val sizes = arrayOf("Size", "X", "S", "M", "L", "XL")
        val quantities = arrayOf("Qnt", "1", "2", "3")

        // Configuration des adaptateurs pour les spinners
        spinerC.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, colors)
        spinerS.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, sizes)
        spinerQ.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, quantities)


        nam.text = name
        prix.text = price
        image.setImageResource(img)

        // Gestion du clic sur le bouton panier
        panier.setOnClickListener {

            val selectedColor = spinerC.selectedItem.toString()
            val selectedSize = spinerS.selectedItem.toString()
            val selectedQuantity = spinerQ.selectedItem.toString()


            if (selectedColor == "Color" || selectedSize == "Size" || selectedQuantity == "Qnt") {

                Toast.makeText(this,"Veuillez sélectionner des options valides",Toast.LENGTH_SHORT).show()
            } else {

                listeP.add(Panier("$name", "$price", img, selectedColor, selectedSize, selectedQuantity))
                Toast.makeText(this,"Ajauter succufl",Toast.LENGTH_SHORT).show()
               //alertDialog

            }
        }
    }
}