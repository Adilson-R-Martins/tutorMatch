package com.tutormatch.service

import com.tutormatch.model.Interest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface InterestService {

    //    BASE_URL  https://tutormatch.free.beeceptor.com/api/


    //    GET	https://tutormatch.free.beeceptor.com/api/interest

    @GET("interest")
    fun getAllInterest(): Call<List<Interest>>

    @GET("interest/{id}?name={interest}")
    fun searchUserByInterest(
        @Path("id") id: String,
        @Query("interest") interest: String
    ): Call<List<Interest>>

    //    POST	https://tutormatch.free.beeceptor.com/api/interest

    @POST("interest")
    fun createInterest(@Body user: Interest): Call<Interest>

    //    PUT	https://tutormatch.free.beeceptor.com/api/interest/:id

    @PUT("interest/{id}")
    fun updateInterest(@Path("id") id: String, @Body interest: Interest): Call<Interest>

    //    DELETE	https://tutormatch.free.beeceptor.com/api/interest/:id

    @DELETE("interest/{id}")
    fun deleteInterest(@Path("id") id: String): Call<Interest>
}