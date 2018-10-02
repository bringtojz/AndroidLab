package com.june.testlab1

import android.content.Intent
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.util.Log
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import kotlinx.android.synthetic.main.activity_main.*
import com.google.firebase.auth.FirebaseAuth
import com.facebook.login.LoginResult
import com.iamhabib.easy_preference.EasyPreference
import com.june.testlab1.ui.ResultActivity


class MainActivity : AppCompatActivity() {

    var callbackManager : CallbackManager? = null
    private var mAuth: FirebaseAuth? = null
    private val TAG: String = "MainActivity"
    private var isLogin : Boolean = false

    private val PERMISSIONS_REQUEST_CALL_PHONE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkCallPhonePermission()


        mAuth = FirebaseAuth.getInstance()
        isLogin = EasyPreference.with(this,"AUTHEN").getBoolean("isLogin",false)


        if(isLogin){
            startActivity(Intent(this, ResultActivity::class.java))
            finish()
        }


        if (mAuth!!.currentUser != null) {
            Log.d(TAG, "Continue With" + mAuth!!.currentUser!!.email)
            startActivity(Intent(this@MainActivity, ResultActivity::class.java))
            finish()
        }




        btnLoginWithApi.setOnClickListener {
            startActivity(Intent(this@MainActivity, LoginWithApiActivity::class.java))
        }

        btnLoginWithEmail.setOnClickListener {
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
        }

        txvRegister.setOnClickListener{
            startActivity(Intent(this@MainActivity, RegisterActivity::class.java))
        }

        callbackManager = CallbackManager.Factory.create()
        btnLoginWithFacebook.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
                    override fun onSuccess(result: LoginResult?) {
                     //   txvResultLogin.text = "Login Success ${ result?.accessToken?.userId }" + "${ result?.accessToken?.token }"
                    }

                    override fun onCancel() {
                    //    txvResultLogin.text = "Login Canceled"
                    }

                    override fun onError(error: FacebookException?) {

                    }

                }
        )




    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager?.onActivityResult(requestCode, resultCode, data)
    }

    private fun checkCallPhonePermission() {

        //Build.VERSION.SDK_INT < 23
        if (ContextCompat.checkSelfPermission(this.applicationContext, android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
        }
        //Build.VERSION.SDK_INT >= 23
        else {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE), PERMISSIONS_REQUEST_CALL_PHONE)
        }
    }



    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>,
                                            grantResults: IntArray) {

        when (requestCode) {
            PERMISSIONS_REQUEST_CALL_PHONE -> {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                } else {

                }
            }
        }
    }

}






