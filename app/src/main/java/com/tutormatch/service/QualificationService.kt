package com.tutormatch.service

import com.tutormatch.model.Qualification
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface QualificationService {

    //    BASE_URL  https://tutormatch.free.beeceptor.com/api/


    //    GET	https://tutormatch.free.beeceptor.com/api/qualification

    @GET("qualification")
    fun getAllQualification(): Call<List<Qualification>>

    @GET("qualification/{id}?name={school}")
    fun searchQualificationBySchool(
        @Path("id") id: String,
        @Query("school") school: String
    ): Call<List<Qualification>>

    //    POST	https://tutormatch.free.beeceptor.com/api/qualification

    @POST("qualification")
    fun createQualification(@Body qualification: Qualification): Call<Qualification>

    //    PUT	https://tutormatch.free.beeceptor.com/api/qualification/:id

    @PUT("qualification/{id}")
    fun updateQualification(
        @Path("id") id: String,
        @Body qualification: Qualification
    ): Call<Qualification>

    //    DELETE	https://tutormatch.free.beeceptor.com/api/users/:id

    @DELETE("qualification/{id}")
    fun deleteQualification(@Path("id") id: String): Call<Qualification>
}