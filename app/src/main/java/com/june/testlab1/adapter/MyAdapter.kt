package com.june.testlab1.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log.e
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.june.testlab1.R
import com.june.testlab1.networking.modelAPI.marvel.ResultsItem
import kotlinx.android.synthetic.main.list_item_recycleview.view.*


class MyAdapter (private val aaaa: List<com.june.testlab1.networking.modelAPI.starwar.ResultsItem>): RecyclerView.Adapter<MyAdapter.MyHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {

        val textView = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_recycleview, parent, false)
        return MyHolder(textView)
    }

    override fun getItemCount(): Int {
        e("Size",aaaa.size.toString())
        return aaaa.size
    }


    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.itemView.txtHeadTopic.text = aaaa[position].name
        holder.itemView.txtDetail.text = aaaa[position].height


    }



    class MyHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}
