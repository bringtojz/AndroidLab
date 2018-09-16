package com.june.testlab1.ui


import android.content.Context
import android.support.v7.widget.AppCompatTextView
import android.view.*
import android.widget.BaseAdapter
import com.june.testlab1.R
import com.june.testlab1.networking.modelAPI.BranchItem



class BranchAdapter (private val context : Context,private val list: ArrayList<BranchItem>) : BaseAdapter(){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view : View = LayoutInflater.from(context).inflate(R.layout.fragment_page1,parent,false)

        val branchnamedetail = view.findViewById(R.id.txtBranchNameDetail) as AppCompatTextView
        val typebranch = view.findViewById(R.id.edtTypeBranch) as AppCompatTextView
        val teldetail = view.findViewById(R.id.txvTelDetail) as AppCompatTextView
        val addressdetail = view.findViewById(R.id.txvAddressDetail) as AppCompatTextView
        val taxbranchname = view.findViewById(R.id.txtTaxBranchNameDetail) as AppCompatTextView

        branchnamedetail.text = list[position].branchName
        typebranch.text = list [position].branchType
        teldetail.text = list[position].taxTelephone
        addressdetail.text = list [position].nameAddress
        taxbranchname.text = list [position].taxBranchName

        return  view

    }

    override fun getItem(position: Int): Any {
        return list [position]
    }

    override fun getItemId(position: Int): Long {
        return  position.toLong()
    }

    override fun getCount(): Int {
        return  list.size
    }

}
