package com.june.testlab1.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Adapter
import com.june.testlab1.R
import com.june.testlab1.adapter.MyAdapter
import com.june.testlab1.networking.APIModule
import com.june.testlab1.networking.modelAPI.getposprice.GetPosPriceRequest
import com.june.testlab1.ui.Ma.ProgressDailog
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_get_pos_price.*
import kotlinx.android.synthetic.main.list_item_recycleview.*

class GetPosPriceActivity : AppCompatActivity() {

    val ShowPostError = "รหัสไปรษณีย์ปลายทางผิด"
    val ShowBranchError = "รหัสสาขาผิด"
    var progressbar: ProgressDailog? = null



    init {
        progressbar = ProgressDailog.shared()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_pos_price)


        btnBack.setOnClickListener {
            finish()
        }

        btnGetPrice.setOnClickListener {

            if (!progressbar!!.isAdded) {
                progressbar?.show(supportFragmentManager, "Loading")
            }

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

        }
    }
}

