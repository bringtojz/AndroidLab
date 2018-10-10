package com.june.testlab1.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.EditorInfo
import com.june.testlab1.R
import com.june.testlab1.networking.APIModule
import com.june.testlab1.networking.modelAPI.BranchReq
import com.june.testlab1.networking.modelAPI.checkprice.CheckPriceReq
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_page2__price.*
import org.jetbrains.anko.toast

class Page2_PriceActivity : AppCompatActivity() {

    val Showerror = "รหัสไปรษณีย์ปลายทางผิด"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2__price)



        btnBack.setOnClickListener {
            finish()
        }

        edtPostIdReceiver.setOnEditorActionListener() { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                var body: CheckPriceReq = CheckPriceReq(edtPostIdReceiver.text.toString(), edtBranchID.text.toString())

                APIModule.checkpriceconnect().checkprice(body)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                //on Next 200 OK
                                {
                                    Log.e("Status", "On Next")

                                    txtServiceDetail.text = it.branch!![0]!!.sV.toString()
                                    edtRouteDetail.setText(it.branch!![0]!!.route)
                                    edtBoxSizeEnvelopDetail.setText(it.branch!![0]!!.priceMap)
                                    edtBoxLDetail.setText(it.branch!![1]!!.priceMap)
                                    edtBoxMDetail.setText(it.branch!![2]!!.priceMap)
                                    edtBoxMiniDetail.setText(it.branch!![3]!!.priceMap)
                                    edtBoxMPlusDetail.setText(it.branch!![4]!!.priceMap)
                                    edtBoxSDetail.setText(it.branch!![5]!!.priceMap)
                                    edtSealBag1Detail.setText(it.branch!![6]!!.priceMap)
                                    edtSealBag2Detail.setText(it.branch!![7]!!.priceMap)
                                    edtSealBag3Detail.setText(it.branch!![8]!!.priceMap)
                                    edtBoxSPlusDetail.setText(it.branch!![9]!!.priceMap)
                                    edtBoxXLDetail.setText(it.branch!![10]!!.priceMap)
                                    edtBoxXXLDetail.setText(it.branch!![11]!!.priceMap)

                                    edtPriceZoneDetail.setText(it.branch!![0]!!.priceZone)
                                    txtZoneSendDetail.setText(it.branch!![0]!!.regionId)
                                },
                                //on Error
                                { Log.e("Status", "On Error")
                                    edtBranchID.error = Showerror
                                    txtServiceDetail.text = ""
                                    edtRouteDetail.setText("")
                                    edtBoxSizeEnvelopDetail.setText("")
                                    edtBoxLDetail.setText("")
                                    edtBoxMDetail.setText("")
                                    edtBoxMiniDetail.setText("")
                                    edtBoxMPlusDetail.setText("")
                                    edtBoxSDetail.setText("")
                                    edtSealBag1Detail.setText("")
                                    edtSealBag2Detail.setText("")
                                    edtSealBag3Detail.setText("")
                                    edtBoxSPlusDetail.setText("")
                                    edtBoxXLDetail.setText("")
                                    edtBoxXXLDetail.setText("")

                                    edtPriceZoneDetail.setText("")
                                    txtZoneSendDetail.setText("")
                                },
                                //On Complete
                                { Log.e("Status", "On Complete") }
                        )

                true
            } else {

                false
            }

        }



        btnCheckPrice.setOnClickListener {
            var body: CheckPriceReq = CheckPriceReq(edtPostIdReceiver.text.toString(), edtBranchID.text.toString())
            APIModule.checkpriceconnect().checkprice(body)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            //on Next 200 OK
                            { Log.e("Status", "On Next")
                                txtServiceDetail.text = it.branch!![0]!!.sV.toString()
                                edtRouteDetail.setText(it.branch!![0]!!.route)
                                edtBoxSizeEnvelopDetail.setText( it.branch!![0]!!.priceMap)
                                edtBoxLDetail.setText(it.branch!![1]!!.priceMap)
                                edtBoxMDetail.setText(it.branch!![2]!!.priceMap)
                                edtBoxMiniDetail.setText(it.branch!![3]!!.priceMap)
                                edtBoxMPlusDetail.setText(it.branch!![4]!!.priceMap)
                                edtBoxSDetail.setText(it.branch!![5]!!.priceMap)
                                edtSealBag1Detail.setText(it.branch!![6]!!.priceMap)
                                edtSealBag2Detail.setText(it.branch!![7]!!.priceMap)
                                edtSealBag3Detail.setText(it.branch!![8]!!.priceMap)
                                edtBoxSPlusDetail.setText(it.branch!![9]!!.priceMap)
                                edtBoxXLDetail.setText(it.branch!![10]!!.priceMap)
                                edtBoxXXLDetail.setText(it.branch!![11]!!.priceMap)

                                edtPriceZoneDetail.setText(it.branch!![0]!!.priceZone)
                                txtZoneSendDetail.setText(it.branch!![0]!!.regionId)
                            },
                            //on Error
                            { Log.e("Status", "On Error")
                                edtBranchID.error = Showerror
                                txtServiceDetail.text = ""
                                edtRouteDetail.setText("")
                                edtBoxSizeEnvelopDetail.setText("")
                                edtBoxLDetail.setText("")
                                edtBoxMDetail.setText("")
                                edtBoxMiniDetail.setText("")
                                edtBoxMPlusDetail.setText("")
                                edtBoxSDetail.setText("")
                                edtSealBag1Detail.setText("")
                                edtSealBag2Detail.setText("")
                                edtSealBag3Detail.setText("")
                                edtBoxSPlusDetail.setText("")
                                edtBoxXLDetail.setText("")
                                edtBoxXXLDetail.setText("")

                                edtPriceZoneDetail.setText("")
                                txtZoneSendDetail.setText("")
                            },
                            //On Complete
                            { Log.e("Status", "On Complete") }
                    )

        }
    }
}




