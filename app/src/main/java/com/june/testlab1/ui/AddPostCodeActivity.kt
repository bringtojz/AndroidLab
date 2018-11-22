package com.june.testlab1.ui

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.june.testlab1.R
import com.june.testlab1.networking.APIModule
import com.june.testlab1.networking.modelAPI.addpostcode.AddPostCodeRequest
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_add_post_code.*
import org.jetbrains.anko.indeterminateProgressDialog
import org.jetbrains.anko.toast


@Suppress("DEPRECATION")
class AddPostCodeActivity : AppCompatActivity() {



    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_post_code)

        val mProgressDialog = indeterminateProgressDialog("แก้ไขราคาเรียบร้อย")

        btnBack.setOnClickListener {
            finish()
        }

        btnAddPostCode.setOnClickListener {
            mProgressDialog.show()
            var body: AddPostCodeRequest = AddPostCodeRequest("KAMON","KAMON",edtPostCode.text.toString(),edtBranchID.text.toString())
            APIModule.setpriceconnect().addpostcode(body)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            //on Next 200 OK
                            { Log.e("Status", "On Next")
                                mProgressDialog.dismiss()

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
                            },
                            //on Error
                            { Log.e("Status", "On Error")
                                toast("รหัสไปรษณีย์มีอยุ่แล้ว")
                            },
                            //On Complete
                            { Log.e("Status", "On Complete") }
                    )



            }

        }
    }

