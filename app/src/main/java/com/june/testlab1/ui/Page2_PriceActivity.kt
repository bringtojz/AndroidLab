package com.june.testlab1.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.june.testlab1.R
import com.june.testlab1.networking.APIModule
import com.june.testlab1.networking.modelAPI.checkprice.CheckPriceReq
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_page2__price.*

class Page2_PriceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2__price)




        btnCheckPrice.setOnClickListener {
            var body: CheckPriceReq = CheckPriceReq(edtPostIdReceiver.text.toString(), edtBranchID.text.toString())
            APIModule.checkpriceconnect().checkprice(body)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            //on Next 200 OK
                            { Log.e("Status", "On Next") },
                            //on Error
                            { Log.e("Status", "On Error") },
                            //On Complete
                            { Log.e("Status", "On Complete") }
                    )

        }
    }
}




