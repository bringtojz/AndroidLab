//package com.june.testlab1.ui
//
//import android.support.v7.widget.RecyclerView
//import android.util.Log.e
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import com.june.testlab1.R
//import com.june.testlab1.networking.modelAPI.marvel.ResultsItem
//import kotlinx.android.synthetic.main.list_item_date.view.*
//import kotlinx.android.synthetic.main.list_item_recycleview.view.*
//
//
//class DateAdapter (private val bbbb: List<com.june.testlab1.networking.modelAPI.starwar.ResultsItem>): RecyclerView.Adapter<MyAdapter.MyHolder>() {
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyHolder {
//
//        val textView = LayoutInflater.from(parent.context)
//                .inflate(R.layout.list_item_date, parent, false)
//        return MyHolder(textView)
//    }
//
//    override fun getItemCount(): Int {
//        e("Size",bbbb.size.toString())
//        return bbbb.size
//    }
//
//
//    override fun onBindViewHolder(holder: MyHolder, position: Int) {
//        holder.itemView.txtBranchID.text = bbbb[position].name
//        holder.itemView.txtDateInto.text = bbbb[position].height
//
//
//    }
//
//
//
//    class MyHolder(view: View) : RecyclerView.ViewHolder(view) {
//
//    }
//}
