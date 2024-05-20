package com.tutormatch.service

import com.tutormatch.model.WorkExperience
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface WorkExperienceService {

    //    BASE_URL  https://tutormatch.free.beeceptor.com/api/


    //    GET	https://tutormatch.free.beeceptor.com/api/workExperience

    @GET("workExperience")
    fun getAllWorkExperience(): Call<List<WorkExperience>>

    @GET("workExperience/{id}?name={company}")
    fun searchWorkExperienceByCompany(
        @Path("id") id: String,
        @Query("company") company: String
    ): Call<List<WorkExperience>>

    //    POST	https://tutormatch.free.beeceptor.com/api/workExperience

    @POST("workExperience")
    fun createWorkExperience(@Body workExperience: WorkExperience): Call<WorkExperience>

    //    PUT	https://tutormatch.free.beeceptor.com/api/workExperience/:id

    @PUT("workExperience/{id}")
    fun updateWorkExperience(
        @Path("id") id: String,
        @Body workExperience: WorkExperience
    ): Call<WorkExperience>

    //    DELETE	https://tutormatch.free.beeceptor.com/api/workExperience/:id

    @DELETE("workExperience/{id}")
    fun deleteWorkExperience(@Path("id") id: String): Call<WorkExperience>

}