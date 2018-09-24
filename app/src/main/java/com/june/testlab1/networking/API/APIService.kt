package com.june.testlab1.networking.API

import com.june.testlab1.networking.modelAPI.*
import com.june.testlab1.networking.modelAPI.marvel.MarvelResponse
import com.june.testlab1.networking.modelAPI.marvel.ResultsItem
import com.june.testlab1.networking.modelAPI.starwar.StarResponse
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

    @POST ("KE_SETUPS/v1/GetPosBranch")
    fun searchbranch (@Body BranchReq: BranchReq) : Observable<SearchResponse>

    @GET ("v1/public/comics")
    fun marvel (@Body marvelResponse: MarvelResponse ) : Observable <ResultsItem>

    @GET ("api/people/")
    fun getstarwar () : Observable <StarResponse>

    @POST ("KE_POSDB/v1/authen_userlogin")
    fun postlogin (@Body LoginwithAPIReq : LoginwithAPIReq) : Observable <ResponseBody>

}