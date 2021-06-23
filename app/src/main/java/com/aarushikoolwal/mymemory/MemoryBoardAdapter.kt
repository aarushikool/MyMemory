package com.aarushikoolwal.mymemory


import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.min as min

class MemoryBoardAdapter(private val context: Context, private val numPieces: Int) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        private const val MARGIN_SIZE =10
        private const val TAG ="MemoryAdapter"
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val cardWidth  = parent.width/2- 2* MARGIN_SIZE
        val cardHeight = parent.height/4 - 2* MARGIN_SIZE
        val cardSideLength = min(cardWidth, cardHeight)
        val view = LayoutInflater.from(context).inflate(R.layout.memory_card, parent, false)
        val layoutParams= view.findViewById<CardView>(R.id.cardView).layoutParams as ViewGroup.MarginLayoutParams
        layoutParams.width= cardSideLength
        layoutParams.height= cardSideLength
        layoutParams.setMargins(MARGIN_SIZE, MARGIN_SIZE, MARGIN_SIZE, MARGIN_SIZE)
        return ViewHolder(view)
    }
    override fun getItemCount() = numPieces

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        fun bind(position: Int){
            //No op
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
              private val imageButton= itemView.findViewById<ImageButton>(R.id.imageButton)
              fun bind(position: Int){
                  imageButton.setOnClickListener {
                      Log.i(TAG, "Clicked on $position")
                  }
              }
    }    }
