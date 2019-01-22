package com.june.testlab1.ui

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide.init
import com.june.testlab1.R
import com.june.testlab1.networking.APIModule
import com.june.testlab1.networking.modelAPI.addpostcode.AddPostCodeRequest
import com.june.testlab1.ui.Ma.ProgressDailog
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_add_post_code.*
import org.jetbrains.anko.indeterminateProgressDialog
import org.jetbrains.anko.toast


@Suppress("DEPRECATION")
class AddPostCodeActivity : AppCompatActivity() {


    var showerror = "กรุณาใส่ชื่อสาขา"
    var showerrorpostcode = "กรุณาใส่รหัสไปรษณีย์"
    var progressbar: ProgressDailog? = null


    init {
        progressbar = ProgressDailog.shared()
    }


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_post_code)



        btnBack.setOnClickListener {
            finish()
        }

        btnAddPostCode.setOnClickListener {

            if (edtPostCode.text.isBlank()) {
                edtPostCode.error = showerrorpostcode
            }

            if (edtBranchID.text.isBlank()) {
                edtBranchID.error = showerror
            } else {
                if (!progressbar!!.isAdded) {
                    progressbar?.show(supportFragmentManager, "Loading")
                }


                var body: AddPostCodeRequest = AddPostCodeRequest("KAMON", "KAMON", edtPostCode.text.toString(), edtBranchID.text.toString())
                APIModule.setpriceconnect().addpostcode(body)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                //on Next 200 OK
                                {
                                    Log.e("Status", "On Next")

                                    edtAmphur0Detail.setText(it.branch!![0]!!.amphur)
                                    edtDistrict0Detail.setText(it.branch!![0]!!.district)
                                    edtAmphur1Detail.setText(it.branch!![1]!!.amphur)
                                    edtDistrict1Detail.setText(it.branch!![1]!!.district)
                                    edtAmphur2Detail.setText(it.branch!![2]!!.amphur)
                                    edtDistrict2Detail.setText(it.branch!![2]!!.district)
                                    edtAmphur3Detail.setText(it.branch!![3]!!.amphur)
                                    edtDistrict3Detail.setText(it.branch!![3]!!.district)
                                    edtAmphur4Detail.setText(it.branch!![4]!!.amphur)
                                    edtDistrict4Detail.setText(it.branch!![4]!!.district)
                                    edtAmphur5Detail.setText(it.branch!![5]!!.amphur)
                                    edtDistrict5Detail.setText(it.branch!![5]!!.district)
                                    edtAmphur6Detail.setText(it.branch!![6]!!.amphur)
                                    edtDistrict6Detail.setText(it.branch!![6]!!.district)
                                    edtAmphur7Detail.setText(it.branch!![7]!!.amphur)
                                    edtDistrict7Detail.setText(it.branch!![7]!!.district)

                                    toast("เพิ่มรหัสไปรษณีย์เรียบร้อย")
                                    progressbar?.dismiss()
                                },
                                //on Error
                                {
                                    Log.e("Status", "On Error")
                                    toast("รหัสไปรษณีย์มีอยุ่แล้ว")
                                    progressbar?.dismiss()
                                },
                                //On Complete
                                { Log.e("Status", "On Complete") }
                        )

            }

        }

    }
}

