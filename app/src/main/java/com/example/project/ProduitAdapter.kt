package com.example.project
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationSet
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class ProduitAdapter(
    private val paysList: List<Produit>,
    private val onItemClick: (Produit) -> Unit // Callback pour les clics
) : RecyclerView.Adapter<ProduitAdapter.PaysViewHolder>() {

    class PaysViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameProduit: TextView = itemView.findViewById(R.id.name)
        val prix: TextView = itemView.findViewById(R.id.prix)
        val image: ImageView = itemView.findViewById(R.id.image)
        val card:CardView=itemView.findViewById(R.id.cardView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaysViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.chaque_item, parent, false)
        return PaysViewHolder(view)
    }

    override fun onBindViewHolder(holder: PaysViewHolder, position: Int) {
        val produit = paysList[position]
        holder.nameProduit.text =produit.name
        holder.prix.text = produit.price
        holder.image.setImageResource(produit.imageProduit)
//        holder.card.startAnimation(AnimationUtils.loadAnimation(holder.itemView.context,R.anim.card_animation))


        // Ajouter un écouteur de clic
        holder.itemView.setOnClickListener {
            onItemClick(produit) // Déclencher le callback avec l'objet Pays
        }
    }

    override fun getItemCount(): Int = paysList.size
}
