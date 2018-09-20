package com.june.testlab1.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.june.testlab1.R
import com.june.testlab1.networking.modelAPI.marvel.ResultsItem
import kotlinx.android.synthetic.main.list_item_recycleview.view.*


class MyAdapter (private val myDataset: List<ResultsItem>): RecyclerView.Adapter<MyAdapter.MyHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {

        val textView = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_recycleview, parent, false)
        return MyHolder(textView)
    }

    override fun getItemCount(): Int {
        return myDataset.size
    }


    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.itemView.txtHeadTopic.text = myDataset[position].title
        holder.itemView.txtDetail.text = myDataset[position].modified


    }



    class MyHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}
