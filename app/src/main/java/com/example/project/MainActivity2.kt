package com.example.project

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        val listeProduit= mutableListOf<Produit>()
val recicler=findViewById<RecyclerView>(R.id.recycler)
        val toute=findViewById<Button>(R.id.toute)
        val jaket=findViewById<Button>(R.id.jaket)
        val spr=findViewById<Button>(R.id.sprdila)
        val retour=findViewById<ImageView>(R.id.retour)
        val recherche=findViewById<EditText>(R.id.recherche)
        listeProduit.apply {
            add(Produit(1,"Sbardille","$20",R.drawable.cccc))
            add(Produit(2,"jaket","$220",R.drawable.ja))
            add(Produit(1,"Sbardille","$570",R.drawable.aaa))
            add(Produit(2,"jaket","$870",R.drawable.jb))
            add(Produit(1,"Sbardille","$90",R.drawable.bbb))
            add(Produit(2,"jaket","$590",R.drawable.jc))
            add(Produit(1,"Sbardille","$389",R.drawable.aaa))
            add(Produit(2,"jaket","$190",R.drawable.jd))
            add(Produit(1,"Sbardille","$356",R.drawable.cccc))
            add(Produit(2,"jaket","$12",R.drawable.je))
            add(Produit(1,"Sbardille","$67",R.drawable.aaa))
            add(Produit(2,"jaket","$90",R.drawable.jf))
            add(Produit(1,"Sbardille","$123",R.drawable.bbb))
            add(Produit(2,"jaket","$678",R.drawable.jk))
            add(Produit(1,"Sbardille","$45",R.drawable.cccc))
            add(Produit(2,"jaket","$300",R.drawable.js))

        }

        recicler.layoutManager = LinearLayoutManager(this)
       val paysAdapter = ProduitAdapter(listeProduit) { produit ->
            // Action lors du clic sur un élément
val i=Intent(this,MainActivity3::class.java).apply {
    putExtra("name",produit.name)
    putExtra("price",produit.price)
    putExtra("image",produit.imageProduit)
}
           startActivity(i)

        }
        recicler.adapter = paysAdapter
toute.setOnClickListener {
    recicler.layoutManager = LinearLayoutManager(this)
    val paysAdapter = ProduitAdapter(listeProduit) { produit ->
        // Action lors du clic sur un élément

    }
    recicler.adapter = paysAdapter
}
        jaket.setOnClickListener {
            val lisNJ=listeProduit.filter { it.id==2 }
            recicler.layoutManager = LinearLayoutManager(this)
            val paysAdapter = ProduitAdapter(lisNJ) { produit ->
                // Action lors du clic sur un élément

            }
            recicler.adapter = paysAdapter

        }
        spr.setOnClickListener {
            val listeNS=listeProduit.filter { it.id==1 }
            recicler.layoutManager = LinearLayoutManager(this)
            val paysAdapter = ProduitAdapter(listeNS) { produit ->
                // Action lors du clic sur un élément

            }
            recicler.adapter = paysAdapter

        }
        retour.setOnClickListener{
            val i=Intent(this,nationnalite::class.java)
            startActivity(i)
        }
recherche.addTextChangedListener(object :TextWatcher{
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        val liste=listeProduit.filter { it.name.startsWith(s,ignoreCase = true) }
        recicler.layoutManager = LinearLayoutManager(this@MainActivity2)
        val paysAdapter = ProduitAdapter(liste) { produit ->
            // Action lors du clic sur un élément

        }
        recicler.adapter = paysAdapter

    }

    override fun afterTextChanged(s: Editable?) {

    }

})
    }
}