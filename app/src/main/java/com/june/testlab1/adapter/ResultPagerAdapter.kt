package com.june.testlab1.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.june.testlab1.ui.Page1Fragment
import com.june.testlab1.ui.Page2Fragment
import com.june.testlab1.ui.Page3Fragment

class ResultPagerAdapter(fragmentManager: FragmentManager, context: Context) : FragmentStatePagerAdapter(fragmentManager) {


    private val PAGE_NUM = 3

    // 2
    override fun getItem(position: Int): Fragment? {

        when(position){
            0 -> {
                return Page1Fragment.newInstance("","")
            }
            1 -> {
                return Page2Fragment.newInstance("","")
            }
            2 -> {
                return Page3Fragment.newInstance("","")
            }
        }
        return Page1Fragment.newInstance("","")
    }

    // 3
    override fun getCount(): Int {
        return PAGE_NUM
    }
}