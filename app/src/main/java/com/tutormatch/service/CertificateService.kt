package com.tutormatch.service

import com.tutormatch.model.Certificate
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface CertificateService {

    //    BASE_URL  https://tutormatch.free.beeceptor.com/api/


    //    GET		https://tutormatch.free.beeceptor.com/api/certificate

    @GET("certificate")
    fun getAllCertificate(): Call<List<Certificate>>

    @GET("certificate/{id}?name={institution}")
    fun searchCertificateByInstitution(
        @Path("id") id: String,
        @Query("institution") institution: String
    ): Call<List<Certificate>>

    //    POST	https://tutormatch.free.beeceptor.com/api/certificate

    @POST("certificate")
    fun createCertificate(@Body certificate: Certificate): Call<Certificate>

    //    PUT	https://tutormatch.free.beeceptor.com/api/certificate/:id

    @PUT("certificate/{id}")
    fun updateCertificate(@Path("id") id: String, @Body certificate: Certificate): Call<Certificate>

    //    DELETE	https://tutormatch.free.beeceptor.com/api/certificate/:id

    @DELETE("certificate/{id}")
    fun deleteCertificate(@Path("id") id: String): Call<Certificate>
}