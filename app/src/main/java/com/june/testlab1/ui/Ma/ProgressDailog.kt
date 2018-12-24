package com.june.testlab1.ui.Ma



import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.DialogFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.june.testlab1.R


class ProgressDailog : DialogFragment() {

    companion object {
        fun shared(): ProgressDailog {
            val dialog = ProgressDailog()
            dialog.isCancelable = true
            return dialog
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = inflater.inflate(R.layout.dialog_loading, container, true)
        dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return view
    }
}