package com.june.testlab1.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.june.testlab1.MapsActivity
import com.june.testlab1.R
import kotlinx.android.synthetic.main.activity_get_pos_price.*
import kotlinx.android.synthetic.main.content_menu_page2_support.*
//import com.june.testlab1.R.id.btnPassTo21
import kotlinx.android.synthetic.main.content_menu_support.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Page2Fragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    var arrayString = arrayOf("JUNE","PEE","THREE","FOUR","FIVE")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         return inflater.inflate (R.layout.fragment_page2, container, false)
    }


    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnCheckPrice.setOnClickListener {
            var intent: Intent = Intent(activity, Page2_PriceActivity::class.java)
            startActivity(intent)
        }


        btnAddPostalCode.setOnClickListener {
            var intent: Intent = Intent(activity, AddPostCodeActivity::class.java)
            startActivity(intent)
        }

        btnSetPrice.setOnClickListener {
            var intent: Intent = Intent(activity, SetPriceActivity::class.java)
            startActivity(intent)
        }
        btnSearchMap.setOnClickListener {
            var intent : Intent = Intent (activity , MapsActivity::class.java)
            startActivity(intent)
        }
        btnCheckPriceBasic.setOnClickListener {
            var intent : Intent = Intent( activity ,GetPosPriceActivity::class.java)
            startActivity(intent)
        }
    }




    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {

        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                Page2Fragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}




