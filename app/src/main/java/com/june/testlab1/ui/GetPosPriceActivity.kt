package com.june.testlab1.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
<<<<<<< HEAD
import android.util.Log
import android.widget.Adapter
import com.june.testlab1.R
import com.june.testlab1.adapter.MyAdapter
=======
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.MenuItem
import android.view.View
import com.june.testlab1.R
import com.june.testlab1.adapter.GetPosPriceAdapter
>>>>>>> 639c98e48aa3f4c302396731f45e3a66e53e357e
import com.june.testlab1.networking.APIModule
import com.june.testlab1.networking.modelAPI.getposprice.GetPosPriceRequest
import com.june.testlab1.networking.modelAPI.getposprice.GetPosPriceResponse
import com.june.testlab1.ui.Ma.ProgressDailog
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_get_pos_price.*
import org.jetbrains.anko.toast
import retrofit2.HttpException

class GetPosPriceActivity : AppCompatActivity(), GetPosPriceAdapter.Listener, View.OnClickListener {

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnGetPrice -> {

                if (!progressbar!!.isAdded) {
                    progressbar?.show(supportFragmentManager, "Loading")
                }

                val body = GetPosPriceRequest(edtBranchID.text.toString())
                APIModule.checkpriceconnect().getposprice(body)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                //on Next 200 OK
                                {
                                    refreshItemview(it)
                                },
                                //on Error
                                {
                                    if (it is HttpException) {
                                        toast(it.response().errorBody().toString())
                                        progressbar?.dismiss()
                                    } else {
                                        toast(it.message!!)
                                        progressbar?.dismiss()
                                    }
                                },
                                //On Complete
                                { Log.e("Status", "On Complete") }
                        )
            }
        }
    }


    val ShowPostError = "รหัสไปรษณีย์ปลายทางผิด"
    val ShowBranchError = "รหัสสาขาผิด"
    var progressbar: ProgressDailog? = null
    var adapter: GetPosPriceAdapter? = null



    init {
        progressbar = ProgressDailog.shared()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_pos_price)

        controlView()

    }

    fun controlView()   {

        myRecyclerview.setHasFixedSize(true)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        myRecyclerview.layoutManager = layoutManager

        lateinit var recyclerView: RecyclerView
        lateinit var viewAdapter: RecyclerView.Adapter<*>
        lateinit var viewManager: RecyclerView.LayoutManager

        setSupportActionBar(toolbar)

        btnGetPrice.setOnClickListener(this)
    }

<<<<<<< HEAD
            var body: GetPosPriceRequest = GetPosPriceRequest(edtBranchID.text.toString())
            APIModule.checkpriceconnect().getposprice(body)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            //on Next 200 OK
                            {
                                Log.e("Status", "On Next")
                                my_recycler_view?.adapter
                                progressbar?.dismiss()
                            },
                            //on Error
                            {
                                Log.e("Status", "On Error")
                                progressbar?.dismiss()
                            },
                            //On Complete
                            { Log.e("Status", "On Complete") }
                    )
=======
    fun refreshItemview(res: GetPosPriceResponse) {
        adapter = GetPosPriceAdapter(res.branch, this)
        myRecyclerview.adapter = adapter
        myRecyclerview.adapter.notifyDataSetChanged()

        progressbar?.dismiss()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
>>>>>>> 639c98e48aa3f4c302396731f45e3a66e53e357e

        }
        return super.onOptionsItemSelected(item)
    }
}

