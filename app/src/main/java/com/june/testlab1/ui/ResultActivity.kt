package com.june.testlab1.ui

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.View
import com.june.testlab1.NonSwipeViewPager
import com.june.testlab1.R
import com.june.testlab1.adapter.ResultPagerAdapter
import kotlinx.android.synthetic.main.activity_result.*


class ResultActivity : AppCompatActivity(), View.OnClickListener {

    private var adapter : ResultPagerAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        initView()

        adapter = ResultPagerAdapter(supportFragmentManager, this)
        viewPager!!.setPageTransformer(false, NonSwipeViewPager.FadePageTransformer())
        viewPager!!.adapter = adapter
    }

    fun initView(){
        btnPage1.setOnClickListener(this)
        btnPage2.setOnClickListener(this)
        btnPage3.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnPage1 -> {
                btnPage1.setBackgroundColor(Color.parseColor("#3b5998"))
                btnPage2.setBackgroundColor(Color.parseColor("#F37021"))
                btnPage3.setBackgroundColor(Color.parseColor("#F37021"))
                viewPager!!.currentItem = 0
            }

            R.id.btnPage2 -> {
                btnPage1.setBackgroundColor(Color.parseColor("#F37021"))
                btnPage2.setBackgroundColor(Color.parseColor("#3b5998"))
                btnPage3.setBackgroundColor(Color.parseColor("#F37021"))
                viewPager!!.currentItem = 1
            }

            R.id.btnPage3 -> {
                btnPage1.setBackgroundColor(Color.parseColor("#F37021"))
                btnPage2.setBackgroundColor(Color.parseColor("#F37021"))
                btnPage3.setBackgroundColor(Color.parseColor("#3b5998"))
                viewPager!!.currentItem = 2
            }
        }
    }
}
