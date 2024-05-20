package com.tutormatch.service

import com.tutormatch.model.Candidate
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface CandidateService {

    //    BASE_URL  https://tutormatch.free.beeceptor.com/api/


    //    GET			https://tutormatch.free.beeceptor.com/api/candidate

    @GET("candidate")
    fun getAllCandidate(): Call<List<Candidate>>

    @GET("candidate/{id}?name={match}")
    fun searchCandidateByMatch(
        @Path("id") id: String,
        @Query("match") candidate: String
    ): Call<List<Candidate>>

    //    POST	https://tutormatch.free.beeceptor.com/api/candidate

    @POST("candidate")
    fun createCandidate(@Body candidate: Candidate): Call<Candidate>

    //    PUT	https://tutormatch.free.beeceptor.com/api/candidate/:id

    @PUT("candidate/{id}")
    fun updateCandidate(@Path("id") id: String, @Body candidate: Candidate): Call<Candidate>

    //    DELETE	https://tutormatch.free.beeceptor.com/api/candidate/:id

    @DELETE("candidate/{id}")
    fun deleteCandidate(@Path("id") id: String): Call<Candidate>
}