package com.june.testlab1.ui.Ma

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.PopupMenu
import android.widget.Toast
import com.june.testlab1.R
import kotlinx.android.synthetic.main.activity_add_date_ma.*
import android.content.DialogInterface
import android.support.v7.app.AlertDialog


class AddDateMaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_date_ma)

        setSupportActionBar(appbar)
        supportActionBar?.title = null

        btnUpload.setOnClickListener {
            showAlertDialog()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.popup_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home -> {
                finish()
                return true
            }
            R.id.menu1 -> {
                Log.e("Camera","Open")
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    fun showAlertDialog(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Select your picture")

// add a list
        val animals = arrayOf("1. Take a picture", "2. Select from your galley")
        builder.setItems(animals) { _, which ->
            when (which) {
                0 -> {
                    //Permission -> CAMERA

                    Log.e("Image","Camera")
                }
                1-> {
                    //Permission -> EXTERNAL STORAGE
                    Log.e("Image","Gallery")
                }
            }
        }

// create and show the alert dialog
        val dialog = builder.create()
        dialog.show()
    }
}



