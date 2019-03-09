package com.june.testlab1.dialog


import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.june.testlab1.R
import com.livinglifetechway.k4kotlin.toast
import kotlinx.android.synthetic.main.popup_callphone.view.*


@Suppress("UNREACHABLE_CODE")
class CallPhoneDialog : DialogFragment() {

    var dialogClickListener: DialogOnClickListener? = null
    var phonenumber: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            onRestoreInstanceState(arguments)
        } else {
            onRestorenonInstanceState(savedInstanceState)
        }

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.popup_callphone, container, false)
        initInstance(view)
        dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return view

    }

    @SuppressLint("WrongViewCast")
    private fun initInstance(view: View) {
        view.txtPhoneNumber.text = phonenumber.toString()

        val btnCancel = view.findViewById<View>(R.id.txtCancelCall)
        val btnCall = view.findViewById<View>(R.id.txtCall)


        btnCancel?.setOnClickListener { view ->
            dialogClickListener?.oncancelcall(view)
            dismiss()
            toast("ยกเลิกการโทร")
        }

        btnCall?.setOnClickListener { view ->
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$phonenumber"))
            startActivity(intent)

        }
    }


    interface DialogOnClickListener {
        fun oncancelcall(v: View?)
        fun oncallphone(string: View?)
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState?.putString("dialog_phonenumber", phonenumber)
    }

    fun onRestorenonInstanceState(bundel: Bundle?) {
        phonenumber = bundel?.getString("dialog_phonenumber")

    }

    fun onRestoreInstanceState(saveInstanceState: Bundle?) {
        phonenumber = saveInstanceState?.getString("dialog_phonenumber")
    }

    companion object {
        fun newInstance(phonenumber: String): CallPhoneDialog {
            val fragmentDialog: CallPhoneDialog = CallPhoneDialog()
            val bundle: Bundle = Bundle()
            bundle.putString("dialog_phonenumber", phonenumber)
            fragmentDialog.arguments = bundle
            return fragmentDialog
        }


    }
    
    open class Builder {
        var phonenumber: String? = null


        fun phonenumberdialog(header: String): Builder {
            phonenumber = header
            return this
        }
        
        fun builder(): CallPhoneDialog {
            return CallPhoneDialog.newInstance(phonenumber!!)
        }
    }
}