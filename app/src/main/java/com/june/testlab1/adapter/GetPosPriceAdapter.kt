package com.june.testlab1.adapter

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.util.Log.e
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.june.testlab1.R
import com.june.testlab1.R.id.*
import com.june.testlab1.networking.modelAPI.getposprice.BranchItem
import kotlinx.android.synthetic.main.list_item_recycleview.view.*
import java.text.DecimalFormat
import java.text.SimpleDateFormat

class GetPosPriceAdapter(private val mData: List<BranchItem?>?,
                         private val listener: Listener) : RecyclerView.Adapter<GetPosPriceAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_recycleview, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = mData?.count()!!

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mData?.get(position)!!, listener, position)
    }

    interface Listener


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @SuppressLint("SetTextI18n", "SimpleDateFormat")
        fun bind(result: BranchItem, listener: Listener, position: Int) {

           val txtSizeDesc = result.sizeDesc
           val txtPriceDetailBKK = result.bKK
           val txtPriceDetailUPC = result.uPC

            itemView.txtSizeDesc.text = txtSizeDesc
            itemView.txtPriceDetailBKK.text = txtPriceDetailBKK
            itemView.txtPriceDetailUPC.text = txtPriceDetailUPC


        }


    }
}