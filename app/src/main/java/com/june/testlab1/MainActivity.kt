package com.june.testlab1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.facebook.*

import kotlinx.android.synthetic.main.activity_main.*
import com.google.firebase.auth.FirebaseAuth

import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import java.util.*


class MainActivity : AppCompatActivity() {

    var callbackManager : CallbackManager? = null
    var mAuth: FirebaseAuth? = null
    private val TAG: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()

        if (mAuth!!.currentUser != null) {
            Log.d(TAG, "Continue With" + mAuth!!.currentUser!!.email)
            startActivity(Intent(this@MainActivity, ResultActivity::class.java))
            finish()

        }
        btnLoginWithEmail.setOnClickListener {
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
        }

        txvRegister.setOnClickListener{
            startActivity(Intent(this@MainActivity,RegisterActivity::class.java))
        }

        callbackManager = CallbackManager.Factory.create()
        btnLoginWithFacebook.registerCallback(callbackManager, object : FacebookCallback<LoginResult>{
            override fun onSuccess(result: LoginResult?) {
                txvResultLogin.text = "Login Success $(result?.accessToken?.userId)" + "$(result?.accessToken?.token)"
            }

            override fun onCancel() {
                Log.d(TAG,"Facebook Cancel")
            }

            override fun onError(error: FacebookException?) {

            }

        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager?.onActivityResult(requestCode, resultCode, data)
    }
}






