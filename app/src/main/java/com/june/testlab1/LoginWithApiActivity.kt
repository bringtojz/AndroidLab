package com.june.testlab1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.iamhabib.easy_preference.EasyPreference
import com.june.testlab1.networking.APIModule
import com.june.testlab1.networking.modelAPI.LoginwithAPIReq
import com.june.testlab1.ui.Page1Fragment
import com.june.testlab1.ui.ResultActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login_with_api.*
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.http.Body


class LoginWithApiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_with_api)

        btnLogin.setOnClickListener {

            var loginRequest = LoginwithAPIReq(edtPassword.text.toString(), edtUserName.text.toString())
            APIModule.loginconnect().postlogin(loginRequest)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            //On Next  200 OK
                            {
                                Log.e("Status", "On Next")
                                EasyPreference.with(this, "AUTHEN").addBoolean("isLogin", true).save()
                                intent = Intent(this@LoginWithApiActivity, ResultActivity::class.java)
                                startActivity(intent)
                                finish()
                            },

                            //On Error
                            { Log.e("Status", "On Error" + it.message) },

                            //On Complete
                            { Log.e("Status", "On Complete") }
                    )
        }

        txvCreateAccount.setOnClickListener{
            startActivity(Intent(this@LoginWithApiActivity, RegisterAPIActivity::class.java))

        }
    }

    }



