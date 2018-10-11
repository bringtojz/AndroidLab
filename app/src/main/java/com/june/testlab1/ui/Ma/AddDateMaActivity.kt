package com.june.testlab1.ui.Ma

import android.Manifest
import android.app.Activity
import android.app.DatePickerDialog
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
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Environment
import android.provider.MediaStore
import android.support.design.widget.Snackbar
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v4.content.FileProvider
import android.support.v7.app.AlertDialog
import android.webkit.PermissionRequest
import android.widget.Button
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.june.testlab1.R.id.menu1
import org.jetbrains.anko.toast
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


class AddDateMaActivity : AppCompatActivity() {

    private val PERMISSIONS_REQUEST_CAMERA = 100
    private val PERMISSIONS_REQUEST_EXTERNAL_STORAGE = 200
    val REQUEST_TAKE_PHOTO  = 1
    var mCurrentPhotoPath: String = ""


    var db : FirebaseFirestore = FirebaseFirestore.getInstance()
    var storage : FirebaseStorage  = FirebaseStorage.getInstance()
    lateinit var dbRef: DocumentReference


    val CAMERA_REQUEST_CODE = 0
    lateinit var imageFilePath: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_date_ma)

        //DatePicker
        val textView: TextView = findViewById(R.id.edtDateInto)
        textView.text = SimpleDateFormat("dd.MM.yyyy").format(System.currentTimeMillis())
        var cal = Calendar.getInstance()
        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val myFormat = "dd.MM.yyyy" // mention the format you need
            val sdf = SimpleDateFormat(myFormat, Locale.US)
            textView.text = sdf.format(cal.time)

        }
        textView.setOnClickListener {
            DatePickerDialog(this@AddDateMaActivity, dateSetListener,
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
        }

        dbRef = db.document("IceCreams/Flavours")


        btnSave.setOnClickListener {
            // Create a storage reference from our app
            val storageRef = storage.reference

            val mountainsRef = storageRef.child("mountains.jpg")
            val mountainImagesRef = storageRef.child("images/mountains.jpg")

            var file = Uri.fromFile(File(mCurrentPhotoPath))
            val riversRef = storageRef.child("images/${file.lastPathSegment}")
            var uploadTask = riversRef.putFile(file)

            uploadTask.addOnFailureListener { exception ->
                // Handle unsuccessful uploads
            }.addOnSuccessListener { taskSnapshot ->
                Log.e("fsdf","Save image success")
                Log.e("uploadSessionUri", taskSnapshot.storage.toString())
                Log.e("uploadSessionUri", uploadTask.snapshot.uploadSessionUri.toString())
                Log.e("uploadSessionUri", taskSnapshot.uploadSessionUri.toString())

            }

            // While the file names are the same, the references point to different files
            mountainsRef.name == mountainImagesRef.name    // true
            mountainsRef.path == mountainImagesRef.path    // false


            btnSave.progress = 0
            val items = HashMap<String, Any>()
            items.put("dateinto", edtDateInto.text.toString())
            db.collection("Maintenance").document(edtBranchID.text.toString().toUpperCase()).set(items).addOnSuccessListener {
                 Toast.makeText(this, "Successfully uploaded to the database :)", Toast.LENGTH_LONG).show()
                 btnSave.progress = 100
                edtBranchID.setText("")
                edtDateInto.setText("")


            }.addOnFailureListener {
                exception: java.lang.Exception -> Toast.makeText(this, exception.toString(), Toast.LENGTH_LONG).show()

            }
        }



        setSupportActionBar(appbar)
        supportActionBar?.title = null

        btnUpload.setOnClickListener {
            showAlertDialog()
        }

        btnBack.setOnClickListener {
            finish()
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
                    checkPermissionCamera()

                }
                1-> {
                    //Permission -> EXTERNAL STORAGE
                    Log.e("Image","Gallery")
                    checkPermissionExternalStore()
                }
            }
        }

        // create and show the alert dialog
        val dialog = builder.create()
        dialog.show()
    }

    private fun checkPermissionExternalStore() {
        //Build.VERSION.SDK_INT < 23
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            Log.e("Read Storage","3333")
        }
        //Build.VERSION.SDK_INT >= 23
        else {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), PERMISSIONS_REQUEST_EXTERNAL_STORAGE)
        }
    }
    override fun onRequestPermissionsReadExternalResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {

        when (requestCode) {
            PERMISSIONS_REQUEST_EXTERNAL_STORAGE -> {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    toast("อัพโหลดรูปจากตัวเครื่อง")
                    dispatchTakePictureIntent()

                } else {
                    Log.e("SSS","22")
                }
            }
        }

    }







    private fun checkPermissionCamera() {
        //Build.VERSION.SDK_INT < 23
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            Log.e("SSS","3333")
            toast("เปิดกล้อง")
            dispatchTakePictureIntent()
        }
        //Build.VERSION.SDK_INT >= 23
        else {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA), PERMISSIONS_REQUEST_CAMERA)
        }
    }
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {

        when (requestCode) {
            PERMISSIONS_REQUEST_CAMERA -> {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    toast("เปิดกล้อง")
                    dispatchTakePictureIntent()

                } else {
                    Log.e("SSS","22")
                }
            }
        }

    }

    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            // Ensure that there's a camera activity to handle the intent
            takePictureIntent.resolveActivity(packageManager)?.also {
                // Create the File where the photo should go
                val photoFile: File? = try {
                    createImageFile()
                } catch (ex: IOException) {
                    // Error occurred while creating the File
                    null
                }
                // Continue only if the File was successfully created
                photoFile?.also {
                    val photoURI: Uri = FileProvider.getUriForFile(
                            this,
                            "com.june.testlab1.fileprovider",
                            it
                    )
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                    startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO)
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            REQUEST_TAKE_PHOTO -> {
                // If request is cancelled, the result arrays are empty.
                if (resultCode == Activity.RESULT_OK) {
                    //
                    Log.e("Path",mCurrentPhotoPath)
                    Glide.with(this)
                            .load(mCurrentPhotoPath)
                            .into(photoImageView)

                } else {
                    Log.e("SSS","22")
                }
            }
        }
    }

    @Throws(IOException::class)
    private fun createImageFile(): File {
        // Create an image file name
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir: File = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(
                "JPEG_${timeStamp}_", /* prefix */
                ".jpg", /* suffix */
                storageDir /* directory */
        ).apply {
            // Save a file: path for use with ACTION_VIEW intents
            mCurrentPhotoPath = absolutePath
        }
    }
}



