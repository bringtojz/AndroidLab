package com.june.testlab1.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.R.id.container
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.june.testlab1.R
import com.june.testlab1.networking.APIModule
import com.june.testlab1.networking.modelAPI.starwar.ResultsItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_page2.*



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


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnCheckPrice.setOnClickListener {
            var intent:Intent = Intent(activity, Page2_PriceActivity::class.java)
            startActivity(intent)
        }


        btnPassTo21.setOnClickListener {
            var intent:Intent = Intent(activity, Page2_1Activity::class.java)
            startActivity(intent)
        }



        APIModule.starwarconnect().getstarwar()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { Log.e("Status", "On Next")
                            viewAdapter = MyAdapter(it.results as List<ResultsItem>)
                                recyclerView.setHasFixedSize(true)
                                recyclerView.layoutManager = viewManager
                                recyclerView.adapter = viewAdapter
                                val nameView = view.findViewById(R.id.recycleview2_1) as TextView

                        },
                        //On Error
                        { Log.e("Status", "On Error") },
                        //On Complete
                        { Log.e("Status", "On Complete") }
                )

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




