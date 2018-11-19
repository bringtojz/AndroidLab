package com.june.testlab1.ui

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.inputmethod.EditorInfo
import com.facebook.R.id.button
import com.june.testlab1.R
import com.june.testlab1.networking.APIModule
import com.june.testlab1.networking.modelAPI.checkprice.CheckPriceReq
import com.june.testlab1.networking.modelAPI.setprice.SetPriceRequest
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_set_price.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.dip
import org.jetbrains.anko.indeterminateProgressDialog
import org.jetbrains.anko.toast

class SetPriceActivity : AppCompatActivity() {

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_price)

        val mProgressDialog = indeterminateProgressDialog("แก้ไขราคาเรียบร้อย")
        val ShowBranchError = "รหัสสาขาผิด"



        btnBack.setOnClickListener {
            finish()
        }

        btnSetPrice.setOnClickListener {
            mProgressDialog.show()
            var body: SetPriceRequest = SetPriceRequest("PC-KAMON","KAMON",edtBranchID.text.toString())
            APIModule.setpriceconnect().setprice(body)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            //on Next 200 OK
                            { Log.e("Status", "On Next")
                                toast("ปรับราคาเรียบร้อย")
                                mProgressDialog.dismiss()
                            },
                            //on Error
                            { Log.e("Status", "On Error")
                               edtBranchID.error = ShowBranchError
                            },
                            //On Complete
                            { Log.e("Status", "On Complete") }
                    )

        }


    }
}

