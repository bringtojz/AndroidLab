package com.june.testlab1.ui

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.june.testlab1.R
import com.june.testlab1.adapter.AddPostCodeAdapter
import com.june.testlab1.networking.APIModule
import com.june.testlab1.networking.modelAPI.addpostcode.AddPostCodeRequest
import com.june.testlab1.networking.modelAPI.addpostcode.AddPostCodeResponse
import com.june.testlab1.ui.Ma.ProgressDailog
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_add_post_code.*
import org.jetbrains.anko.toast
import retrofit2.HttpException


@Suppress("DEPRECATION")
class AddPostCodeActivity : AppCompatActivity() ,AddPostCodeAdapter.Listener , View.OnClickListener{


    override fun onClick(v: View?) {

        when (v?.id){
            R.id.btnAddPost1 ->{
                if (!progressbar!!.isAdded) {
                    progressbar?.show(supportFragmentManager, "Loading")
                }
                if(edtBranchID.text.isBlank()){
                    edtBranchID.error = showerror
                }
                if(edtPostCode.text.isBlank()){
                    edtPostCode.error = showerrorpostcode
                }

                val builder = AlertDialog.Builder(this@AddPostCodeActivity)
                builder.setTitle("เพิ่มรหัสไปรษณีย์สำเร็จแล้ว")
                builder.setPositiveButton("OK") { dialog, which ->
                    Toast.makeText(applicationContext, "เพิ่มรหัสไปรษณีย์สำเร็จแล้ว.", Toast.LENGTH_SHORT).show()
                }
                val dialog: AlertDialog = builder.create()

                var body = AddPostCodeRequest("KAMON", "KAMON", edtPostCode.text.toString(), edtBranchID.text.toString())
                APIModule.setpriceconnect().addpostcode(body)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                //on Next 200 OK
                                {
                                    refreshItemview(it)
                                    dialog.show()
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


    var showerror = "กรุณาใส่ชื่อสาขา"
    var showerrorpostcode = "กรุณาใส่รหัสไปรษณีย์"
    var progressbar: ProgressDailog? = null
    var adapter: AddPostCodeAdapter? = null


    init {
        progressbar = ProgressDailog.shared()
    }


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_post_code)

        controlView()

    }

    fun controlView()   {

        myRecyclerviewAddPost.setHasFixedSize(true)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        myRecyclerviewAddPost.layoutManager = layoutManager

        lateinit var recyclerView: RecyclerView
        lateinit var viewAdapter: RecyclerView.Adapter<*>
        lateinit var viewManager: RecyclerView.LayoutManager

        setSupportActionBar(toolbar)

        btnAddPost1.setOnClickListener(this)
    }


    fun refreshItemview(res: AddPostCodeResponse) {
        adapter = AddPostCodeAdapter(res.branch, this)
        myRecyclerviewAddPost.adapter = adapter
        myRecyclerviewAddPost.adapter.notifyDataSetChanged()

        progressbar?.dismiss()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }

        }
        return super.onOptionsItemSelected(item)
    }
}



