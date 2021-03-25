package com.shisheo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shisheo.R
import com.shisheo.model.Item

class ListAdapter(private val mContext: Context, var mData: List<Item>) :
    RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_restaurant, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = mData[position]
        holder.name.text=item.name
        holder.image.setImageResource(R.drawable.restauant_one)
        holder.offer.text = item.offer
        holder.payment.text = item.payment
        holder.price.text = item.price
        holder.time.text = item.time
        holder.typeFood.text = item.type
        holder.rate.rating= item.rating!!.toFloat()
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    public fun setListOfRestaurant(mData :List<Item>) {
        this.mData = mData;
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         var name:TextView = itemView.findViewById(R.id.name);
         var typeFood:TextView= itemView.findViewById(R.id.typeFood);
         var price:TextView= itemView.findViewById(R.id.price);
         var time:TextView= itemView.findViewById(R.id.time);
         var offer:TextView= itemView.findViewById(R.id.offer);
         var payment:TextView= itemView.findViewById(R.id.payMode);
         var image:ImageView= itemView.findViewById(R.id.imageView);
         var rate:RatingBar= itemView.findViewById(R.id.ratingBar);
    }

}