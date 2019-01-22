package com.june.testlab1.ui

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import com.june.testlab1.R
import com.june.testlab1.networking.APIModule
import com.june.testlab1.networking.modelAPI.searchbranch.BranchReq
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_page1.*
import android.content.Intent
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

import com.livinglifetechway.k4kotlin.toast


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class Page1Fragment : Fragment(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var map: GoogleMap
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private var listener: OnFragmentInteractionListener? = null


    override fun onMapReady(p0: GoogleMap?) {
        map.getUiSettings().setZoomControlsEnabled(true)
        map.setOnMarkerClickListener(this)

        val myPlace = LatLng(40.73, -73.99)  // this is New York
        map.addMarker(MarkerOptions().position(myPlace).title("My Favorite City"))
        map.moveCamera(CameraUpdateFactory.newLatLng(myPlace))
    }

    override fun onMarkerClick(p0: Marker?) = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this.requireActivity())
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_page1, container, false)
    }

    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        edtBranchID.setOnEditorActionListener() { v, actionId, event ->
            if(actionId == EditorInfo.IME_ACTION_SEARCH){
                var body: BranchReq = BranchReq(edtBranchID.text.toString())

                APIModule.connectsearchbranch().searchbranch(body)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                //on Next 200 OK
                                {
                                    Log.e("Status", "On Next")
                                    txtBranchNameDetail.text = it.branch!![0]!!.branchName.toString()
                                    edtTypeBranch.setText(it.branch!![0]!!.branchType)
                                    btnCallPhone.isEnabled = true
                                    edtTelDetail.setText(it.branch!![0]!!.taxTelephone)
                                    txvAddressDetail.text = it.branch!![0]!!.nameAddress.toString()
                                    txtTaxBranchNameDetail.setText(it.branch!![0]!!.taxBranchName)
                                    txtTimeOpenDetail.text = it.branch!![0]!!.operatingDatetime.toString()
                                    edtRegionNameDetail.setText(it.branch!![0]!!.regionName)
                                },
                                //on Error
                                { Log.e("Status", "On Error")
                                    toast("ใส่ชื่อ branch ผิด.")
                                },
                                //On Complete
                                { Log.e("Status", "On Complete") }
                        )

                true
            } else {
                false
            }


        }

        btnCallPhone.setOnClickListener {
            callPhone(edtTelDetail.text.toString())

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
                                edtTelDetail.isEnabled = true
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

    private  fun callPhone(mobileNo : String){
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$mobileNo"))
        startActivity(intent)
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState?.putCharSequence("BranchName", txtBranchNameDetail.text.toString())
        outState?.putCharSequence("Address", txvAddressDetail.text.toString())
        outState?.putCharSequence("TimeOpen", txtTimeOpenDetail.text.toString())

    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        val branchName = savedInstanceState?.getString("BranchName")
        val address = savedInstanceState?.getString("Address")
        val timeOpen = savedInstanceState?.getString("TimeOpen")


        address.let {
            txvAddressDetail.text = it
        }

        branchName.let {
            txtBranchNameDetail.text = it

        }
        timeOpen.let {
            txtTimeOpenDetail.text = it

        }

    }
}



