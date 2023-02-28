package com.mobdeve.tighee.emailapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.mobdeve.tighee.emailapplication.databinding.ItemLayoutBinding

class MyAdapter(private val data: ArrayList<Email>, private val myActivityResultLauncher: ActivityResultLauncher<Intent>) : Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // Initialize the ViewBinding of an item's layout
        val itemViewBinding: ItemLayoutBinding = ItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        val myViewHolder = MyViewHolder(itemViewBinding)

        // Provide logic for clicking on anywhere on the entire itemView of the ViewHolder
        myViewHolder.itemView.setOnClickListener {
            /*  TODO:
             *      1. Declare an intent heading to EmailDetailsActivity
             *      2. Place Email info into the intent, including the current position
             *      3. Using the appropriate ActivityResultLauncher, launch using your intent
             * */

            val intent = Intent(myViewHolder.itemView.getContext(), EmailDetailsActivity::class.java)

            intent.putExtra("RECEIVER_KEY", data[myViewHolder.adapterPosition].receiver)
            intent.putExtra("SUBJECT_KEY", data[myViewHolder.adapterPosition].subject)
            intent.putExtra("BODY_KEY", data[myViewHolder.adapterPosition].body)
            intent.putExtra("POSITION_KEY", myViewHolder.adapterPosition)

            myActivityResultLauncher.launch(intent)
        }
        return myViewHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}