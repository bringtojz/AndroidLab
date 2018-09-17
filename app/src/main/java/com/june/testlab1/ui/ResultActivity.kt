package com.june.testlab1.ui

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.june.testlab1.R
import kotlinx.android.synthetic.main.activity_result.*


class ResultActivity : AppCompatActivity(), View.OnClickListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        initView()

        supportFragmentManager
                .beginTransaction()
                .addToBackStack(null)
                .add(R.id.container,Page1Fragment.newInstance("",""), "rageComicList")
                .commit()
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

                supportFragmentManager
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.container,Page1Fragment.newInstance("",""), "rageComicList")
                        .commit()

            }

            R.id.btnPage2 -> {
                btnPage1.setBackgroundColor(Color.parseColor("#F37021"))
                btnPage2.setBackgroundColor(Color.parseColor("#3b5998"))
                btnPage3.setBackgroundColor(Color.parseColor("#F37021"))

                supportFragmentManager
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.container,Page2Fragment.newInstance("",""), "rageComicList")
                        .commit()
            }

            R.id.btnPage3 -> {
                btnPage1.setBackgroundColor(Color.parseColor("#F37021"))
                btnPage2.setBackgroundColor(Color.parseColor("#F37021"))
                btnPage3.setBackgroundColor(Color.parseColor("#3b5998"))

                supportFragmentManager
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.container,Page3Fragment.newInstance("",""), "rageComicList")
                        .commit()
            }
        }
    }
}
