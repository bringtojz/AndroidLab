package com.june.testlab1.ui.Ma

import android.Manifest
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import android.widget.Toast
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.june.testlab1.R
import com.livinglifetechway.quickpermissions.annotations.WithPermissions
import kotlinx.android.synthetic.main.activity_ma.*


class MaActivity : AppCompatActivity() {

    var db : FirebaseFirestore = FirebaseFirestore.getInstance()
//    lateinit var dbRef: CollectionReference = db.collection("Maintenance")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ma)

        btnAddDateMa.setOnClickListener {
            var intent: Intent = Intent(this@MaActivity, AddDateMaActivity::class.java)
            startActivity(intent)
        }

        btnBack.setOnClickListener {
            finish()
        }

        val calendarView = findViewById<CalendarView>(R.id.calendarView)
        calendarView?.setOnDateChangeListener { view, year, month, dayOfMonth ->

            val msg = "Selected date is " + dayOfMonth + "/" + (month + 1) + "/" + year
            Toast.makeText(this@MaActivity, msg, Toast.LENGTH_SHORT).show()
        }
    }
}

