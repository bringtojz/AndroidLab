package com.june.testlab1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.june.testlab1.networking.APIModule
import com.june.testlab1.networking.modelAPI.user.RegisterApiReq
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_register_api.*

class RegisterAPIActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_api)

        btnRegister.setOnClickListener {
            var registerApiReq = RegisterApiReq (edtUserName.text.toString(),edtUserId.text.toString(),edtPassword.text.toString())
            APIModule.loginconnect().registerwithapi(registerApiReq)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            //On Next  200 OK
                            { Log.e("Status", "On Next") },
                            //On Error
                            { Log.e("Status", "On Error") },
                            //On Complete
                            { Log.e("Status", "On Complete") }
                    )
        }
    }
}
