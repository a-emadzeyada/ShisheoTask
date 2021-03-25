package com.shisheo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shisheo.R
import com.shisheo.adapter.ListAdapter
import com.shisheo.model.Item

class Home : Fragment() {
    private var items: MutableList<Item>? = ArrayList()
    private var adapter: ListAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.home, container, false)
        setData()
        val listOfRestaurant = view.findViewById<RecyclerView>(R.id.listOfRestaurant)
        val manager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        adapter = ListAdapter(context!!, items!!)
        listOfRestaurant.layoutManager = manager
        listOfRestaurant.adapter = adapter
        return view
    }

    private fun setData() {
        for (i in 1..10) {
            val item = Item()
            item.name = "Holy Grail Restaurant $i"
            item.offer = (i * 10).toString() + "% Off Selected items"
            item.payment = "Cash-on-delivery"
            item.price = "Delivery: AED " + (i * 10).toString()
            item.rating = (i % 5).toString()
            item.time = "Delivery with 2$i min"
            item.type = "Arabic, Lebanese, Chinese"
            items?.add(item)
        }
    }

    companion object {
        fun newInstance(): Home = Home()
    }
}