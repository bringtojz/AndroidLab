package com.june.testlab1.networking

import com.june.testlab1.BuildConfig
import com.june.testlab1.networking.API.APIService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class APIModule {

    companion object {

        fun connect() : APIService {

            val logging = HttpLoggingInterceptor()
            logging.apply {
                level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            }

            var header = Interceptor {chain ->
                        chain.proceed(chain.request().newBuilder()
                                .addHeader("Content-Type","application/json")
                                .addHeader("app_name","TEST")
                                .build())
                    }

            val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .addInterceptor(header)
                    .connectTimeout(20,TimeUnit.SECONDS)
                    .writeTimeout(20,TimeUnit.SECONDS)
                    .readTimeout(20,TimeUnit.SECONDS)
                    .build()

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(MoshiConverterFactory.create())
                    .client(okHttpClient)
                    .baseUrl("http://api.bigboom.me:8080")
                    .build()

            return retrofit.create(APIService::class.java)
        }

        fun connectnasa (): APIService {

            val logging = HttpLoggingInterceptor ()
            logging.apply {
                level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BASIC else HttpLoggingInterceptor.Level.NONE
            }
            var header = Interceptor { chain ->
                chain.proceed(chain.request().newBuilder()
                        .addHeader("Content-Type", "application/json")
                        .addHeader("app_name", "Nasa")
                        .build())
            }
                val okHttpClient = OkHttpClient.Builder()
                        .addInterceptor(logging)
                        .addInterceptor(header)
                        .connectTimeout(20,TimeUnit.SECONDS)
                        .writeTimeout(20,TimeUnit.SECONDS)
                        .readTimeout(20,TimeUnit.SECONDS)
                        .build()
                val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(MoshiConverterFactory.create())
                    .client(okHttpClient)
                    .baseUrl("https://api.nasa.gov:8080")
                    .build()

            return retrofit.create(APIService::class.java)
            }

        fun connectsearchbranch (): APIService {

            val logging = HttpLoggingInterceptor ()
            logging.apply {
                level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            }
            var header = Interceptor { chain ->
                chain.proceed(chain.request().newBuilder()
                        .addHeader("Content-Type", "application/json")
                        .addHeader("app_id","SETUP")
                        .addHeader("app_key","85FDB4A6-B919-439E-9F56-195D51C5A2F3")
                        .build())
            }
            val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .addInterceptor(header)
                    .connectTimeout(20,TimeUnit.SECONDS)
                    .writeTimeout(20,TimeUnit.SECONDS)
                    .readTimeout(20,TimeUnit.SECONDS)
                    .build()
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(MoshiConverterFactory.create())
                    .client(okHttpClient)
                    .baseUrl("http://58.137.103.187:8081")
                    .build()

            return retrofit.create(APIService::class.java)
        }
        fun starwarconnect (): APIService {

            val logging = HttpLoggingInterceptor ()
            logging.apply {
                level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            }
            var header = Interceptor { chain ->
                chain.proceed(chain.request().newBuilder()
                        .addHeader("Content-Type", "application/json")
                        .build())
            }
            val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .addInterceptor(header)
                    .connectTimeout(20,TimeUnit.SECONDS)
                    .writeTimeout(20,TimeUnit.SECONDS)
                    .readTimeout(20,TimeUnit.SECONDS)
                    .build()
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(MoshiConverterFactory.create())
                    .client(okHttpClient)
                    .baseUrl("https://swapi.co")
                    .build()

            return retrofit.create(APIService::class.java)
        }
        fun loginconnect (): APIService {

            val logging = HttpLoggingInterceptor ()
            logging.apply {
                level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            }
            var header = Interceptor { chain ->
                chain.proceed(chain.request().newBuilder()
                        .addHeader("Content-Type", "application/json")
                        .addHeader("app_id", "poslogin")
                        .addHeader("app_key", "12345")
                        .build())
            }
            val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .addInterceptor(header)
                    .connectTimeout(20,TimeUnit.SECONDS)
                    .writeTimeout(20,TimeUnit.SECONDS)
                    .readTimeout(20,TimeUnit.SECONDS)
                    .build()
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(MoshiConverterFactory.create())
                    .client(okHttpClient)
                    .baseUrl("http://58.137.103.187:8081")
                    .build()

            return retrofit.create(APIService::class.java)
        }

        fun checkpriceconnect (): APIService {

            val logging = HttpLoggingInterceptor ()
            logging.apply {
                level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            }
            var header = Interceptor { chain ->
                chain.proceed(chain.request().newBuilder()
                        .addHeader("Content-Type", "application/json")
                        .addHeader("app_id", "SETUP")
                        .addHeader("app_key", "85FDB4A6-B919-439E-9F56-195D51C5A2F3")
                        .build())
            }
            val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .addInterceptor(header)
                    .connectTimeout(20,TimeUnit.SECONDS)
                    .writeTimeout(20,TimeUnit.SECONDS)
                    .readTimeout(20,TimeUnit.SECONDS)
                    .build()
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(MoshiConverterFactory.create())
                    .client(okHttpClient)
                    .baseUrl("http://58.137.103.187:8081")
                    .build()

            return retrofit.create(APIService::class.java)
        }

        fun setpriceconnect (): APIService {

            val logging = HttpLoggingInterceptor ()
            logging.apply {
                level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            }
            var header = Interceptor { chain ->
                chain.proceed(chain.request().newBuilder()
                        .addHeader("Content-Type", "application/json")
                        .addHeader("app_id", "SETUP")
                        .addHeader("app_key", "85FDB4A6-B919-439E-9F56-195D51C5A2F3")
                        .build())
            }
            val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .addInterceptor(header)
                    .connectTimeout(20,TimeUnit.SECONDS)
                    .writeTimeout(20,TimeUnit.SECONDS)
                    .readTimeout(20,TimeUnit.SECONDS)
                    .build()
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(MoshiConverterFactory.create())
                    .client(okHttpClient)
                    .baseUrl("http://58.137.103.187:8081")
                    .build()

            return retrofit.create(APIService::class.java)
        }
        }
    }

