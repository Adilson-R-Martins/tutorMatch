package com.tutormatch.service

import com.tutormatch.model.Review
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface ReviewService {

    //    BASE_URL  https://tutormatch.free.beeceptor.com/api/


    //    GET	https://tutormatch.free.beeceptor.com/api/review

    @GET("review")
    fun getAllReview(): Call<List<Review>>

    @GET("review/{id}?name={avgReviewScore}")
    fun searchReviewByAvgReviewScore(
        @Path("id") id: String,
        @Query("avgReviewScore") avgReviewScore: String
    ): Call<List<Review>>

    //    POST	https://tutormatch.free.beeceptor.com/api/review

    @POST("review")
    fun createReview(@Body review: Review): Call<Review>

    //    PUT	https://tutormatch.free.beeceptor.com/api/review/:id

    @PUT("review/{id}")
    fun updateReview(@Path("id") id: String, @Body review: Review): Call<Review>

    //    DELETE	https://tutormatch.free.beeceptor.com/api/review/:id

    @DELETE("review/{id}")
    fun deleteReview(@Path("id") id: String): Call<Review>
}