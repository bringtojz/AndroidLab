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
import kotlinx.android.synthetic.main.list_item_addpost_recycleview.view.*
import kotlinx.android.synthetic.main.list_item_recycleview.view.*
import java.text.DecimalFormat
import java.text.SimpleDateFormat

class AddPostCodeAdapter(private val mData: List<com.june.testlab1.networking.modelAPI.addpostcode.BranchItem?>?,
                         private val listener: Listener) : RecyclerView.Adapter<AddPostCodeAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_addpost_recycleview, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = mData?.count()!!

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mData?.get(position)!!, listener, position)
    }

    interface Listener


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @SuppressLint("SetTextI18n", "SimpleDateFormat")
        fun bind(result: com.june.testlab1.networking.modelAPI.addpostcode.BranchItem, listener: Listener, position: Int) {

            val txtPostcode = result.postalcode
            val txtAmphur = result.amphur
            val txtDistrict = result.district
            val txtRemark = result.remark

            itemView.txtPostcode.text = txtPostcode
            itemView.txtAmphur.text = txtAmphur
            itemView.txtDistrict.text = txtDistrict
            itemView.txtRemark.text = txtRemark


        }


    }
}