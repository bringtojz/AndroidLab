package com.june.testlab1

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_result.*
import org.jetbrains.anko.toast

class ResultActivity : AppCompatActivity() {

    var mAuth : FirebaseAuth? = null
    var mAuthListener: FirebaseAuth.AuthStateListener? =  null
    private val TAG:String = "Result Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        mAuth = FirebaseAuth.getInstance()

        val user = mAuth!!.currentUser

        txvEmail.text = user!!.email
        txvUid.text = user.uid

        mAuthListener = FirebaseAuth.AuthStateListener { firebaseAuth ->
            val users = firebaseAuth.currentUser
            if (users == null){
                startActivity(Intent(this@ResultActivity, LoginActivity::class.java))
                finish()
            }
        }
        btnSignOut.setOnClickListener{
            mAuth!!.signOut()
            toast("Signed Out!")
            Log.d(TAG,"Signed Out!")
            startActivity(Intent(this@ResultActivity,MainActivity::class.java))
        }
        btnSearchActivity.setOnClickListener{
            startActivity(Intent(this@ResultActivity,MainMenuActivity::class.java))
        }
    }
    override fun onStart() {
        super.onStart()
        mAuth!!.addAuthStateListener { mAuthListener }
    }

    override fun onStop() {
        super.onStop()
        if (mAuthListener != null){mAuth!!.removeAuthStateListener { mAuthListener }}
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK){ moveTaskToBack(true)}
        return super.onKeyDown(keyCode, event)
    }
    }

