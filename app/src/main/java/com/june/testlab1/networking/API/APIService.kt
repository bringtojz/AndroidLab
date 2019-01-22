package com.june.testlab1.networking.API

import com.june.testlab1.networking.modelAPI.*
import com.june.testlab1.networking.modelAPI.addpostcode.AddPostCodeRequest
import com.june.testlab1.networking.modelAPI.addpostcode.AddPostCodeResponse
import com.june.testlab1.networking.modelAPI.checkprice.CheckPriceReq
import com.june.testlab1.networking.modelAPI.checkprice.CheckPriceResponse
import com.june.testlab1.networking.modelAPI.marvel.MarvelResponse
import com.june.testlab1.networking.modelAPI.marvel.ResultsItem
import com.june.testlab1.networking.modelAPI.searchbranch.BranchReq
import com.june.testlab1.networking.modelAPI.searchbranch.SearchBranchResponse
import com.june.testlab1.networking.modelAPI.setprice.SetPriceRequest
import com.june.testlab1.networking.modelAPI.setprice.SetPriceRespone
import com.june.testlab1.networking.modelAPI.starwar.StarResponse
import com.june.testlab1.networking.modelAPI.user.RegisterApiReq
import com.june.testlab1.networking.modelAPI.user.RegisterApiResponse
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface APIService {

    @POST("Account/Login")
    fun login(@Body loginRequest: LoginRequest) : Observable<ResponseBody>

    @POST ("planetary/apod")
    fun nasa (@Body nasa: Nasa): Observable<ResponseBody>

    //ค้นหาสาขา
    @POST ("possupportwebapi/v1/GetPosBranch")
    fun searchbranch (@Body BranchReq: BranchReq) : Observable<SearchBranchResponse>

    @POST ("KE_POSDB/v1/authen_userlogin")
    fun postlogin (@Body LoginwithAPIReq : LoginwithAPIReq) : Observable <ResponseBody>

    @POST ("KE_POSDB/v1/CreateUserLogin")
    fun registerwithapi (@Body RegisterApiReq : RegisterApiReq) : Observable <RegisterApiResponse>

    //เช็คราคาใน POS
    @POST ("possupportwebapi/v1/updatePosPriceCheck")
    fun checkprice (@Body CheckPriceReq : CheckPriceReq) : Observable <CheckPriceResponse>

    //อัพเดทราคาใน POS
    @POST ("possupportwebapi/v1/updatePosPrice")
    fun setprice (@Body SetPriceRequest : SetPriceRequest ) : Observable <SetPriceRespone>

    //เพิ่มรหัสไปรษณีย์ครับ
    @POST ("possupportwebapi/v1/updateeMasterZipcodeEffectiveDate")
    fun addpostcode (@Body AddPostCodeRequest: AddPostCodeRequest ) : Observable <AddPostCodeResponse>
}