package com.june.testlab1.ui.Ma

import android.Manifest
import android.app.Activity
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
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Environment
import android.provider.MediaStore
import android.support.design.widget.Snackbar
import android.support.v4.content.FileProvider
import android.support.v7.app.AlertDialog
import android.webkit.PermissionRequest
import com.june.testlab1.R.id.menu1
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


class AddDateMaActivity : AppCompatActivity() {

    val CAMERA_REQUEST_CODE = 0
    lateinit var imageFilePath: String

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
        val uploadimg = arrayOf("1. Take a picture", "2. Select from your galley")
        builder.setItems(uploadimg) { _, which ->
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



