package com.example.project

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class nationnalite : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nationnalite)
       val femme=findViewById<ImageView>(R.id.femme)
        val homme=findViewById<ImageView>(R.id.homme)
        femme.setOnClickListener{
            val i=Intent(this,MainActivity::class.java)
            startActivity(i)
        }
        homme.setOnClickListener{
            val i=Intent(this,MainActivity2::class.java)
            startActivity(i)
        }
    }
}