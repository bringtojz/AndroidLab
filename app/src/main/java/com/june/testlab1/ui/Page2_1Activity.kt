package com.june.testlab1.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.june.testlab1.R
import com.june.testlab1.networking.APIModule
import com.june.testlab1.networking.modelAPI.starwar.ResultsItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class Page2_1Activity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2_1)


        viewManager = LinearLayoutManager(this)


        APIModule.starwarconnect().getstarwar()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        //On Next
                        { Log.e ("Status", "On Next")

                            viewAdapter = MyAdapter(it.results as List<ResultsItem>)
                            recyclerView = findViewById<RecyclerView>(R.id.recycleview2_1).apply {
                                setHasFixedSize(true)
                                layoutManager = viewManager
                                adapter = viewAdapter

                            }
                        },
                        //On Error
                        {Log.e("Status","On Error")},
                        //On Complete
                        {Log.e("Status","On Complete")}
                )

    }

}
