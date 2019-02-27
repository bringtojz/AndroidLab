package com.june.testlab1.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log.e
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.june.testlab1.R
import kotlinx.android.synthetic.main.list_item_recycleview.view.*


class MyAdapter (private val aaaa: ArrayList<com.june.testlab1.networking.modelAPI.getposprice.BranchItem>): RecyclerView.Adapter<MyAdapter.MyHolder>() {


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
        holder.itemView.txtSizeDesc.text = aaaa[position].sizeDesc
        holder.itemView.txtPriceDetailBKK.text = aaaa[position].bKK
        holder.itemView.txtPriceDetailUPC.text = aaaa[position].uPC


    }



    class MyHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}
