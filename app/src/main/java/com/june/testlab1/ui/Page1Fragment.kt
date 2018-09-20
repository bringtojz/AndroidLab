package com.june.testlab1.ui

import android.content.Context
import android.net.Uri
import android.os.AsyncTask
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo

import com.june.testlab1.R
import com.june.testlab1.networking.APIModule
import com.june.testlab1.networking.modelAPI.BranchReq
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_page1.*
import android.content.Intent




private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Page1Fragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        }




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_page1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        edtTelDetail.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL ,Uri.parse("tel:edtTelDetail"))
            startActivity(intent)

    }
        edtBranchID.setOnEditorActionListener() { v, actionId, event ->
            if(actionId == EditorInfo.IME_ACTION_SEARCH){
                var body: BranchReq = BranchReq(edtBranchID.text.toString())

                APIModule.connectsearchbranch().searchbranch(body)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                //on Next 200 OK
                                { Log.e("Status", "On Next")
                                    txtBranchNameDetail.text = it.branch!![0]!!.branchName.toString()
                                    edtTypeBranch.setText( it.branch!![0]!!.branchType)
                                    edtTelDetail.setText (it.branch!![0]!!.taxTelephone)
                                    txvAddressDetail.text = it.branch!![0]!!.nameAddress.toString()
                                    txtTaxBranchNameDetail.setText (it.branch!![0]!!.taxBranchName)
                                    txtTimeOpenDetail.text = it.branch!![0]!!.operatingDatetime.toString()

                                },
                                //on Error
                                { Log.e("Status", "On Error") },
                                //On Complete
                                { Log.e("Status", "On Complete") }
                        )

                true
            } else {
                false
            }
        }

        btnSearch.setOnClickListener {
            var body: BranchReq = BranchReq(edtBranchID.text.toString())

            APIModule.connectsearchbranch().searchbranch(body)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            //on Next 200 OK
                            { Log.e("Status", "On Next")
                                txtBranchNameDetail.text = it.branch!![0]!!.branchName.toString()
                                edtTypeBranch.setText( it.branch!![0]!!.branchType)
                                edtTelDetail.setText (it.branch!![0]!!.taxTelephone)
                                txvAddressDetail.text = it.branch!![0]!!.nameAddress.toString()
                                txtTaxBranchNameDetail.setText (it.branch!![0]!!.taxBranchName)
                                txtTimeOpenDetail.text = it.branch!![0]!!.operatingDatetime.toString()

                            },
                            //on Error
                            { Log.e("Status", "On Error") },
                            //On Complete
                            { Log.e("Status", "On Complete") }
                    )

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
                Page1Fragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}



