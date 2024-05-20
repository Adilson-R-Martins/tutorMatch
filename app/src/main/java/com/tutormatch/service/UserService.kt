package com.tutormatch.service

import com.tutormatch.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface UserService {

    //    BASE_URL  https://tutormatch.free.beeceptor.com/api/


    //    GET	https://tutormatch.free.beeceptor.com/api/users/

    @GET("users")
    fun getAllUsers(): Call<List<User>>

    @GET("users/{id}?name={name}")
    fun searchUserByName(@Path("id") id: String, @Query("name") name: String): Call<List<User>>

    //    POST	https://tutormatch.free.beeceptor.com/api/users

    @POST("users")
    fun createUser(@Body user: User): Call<User>

    //    PUT	https://tutormatch.free.beeceptor.com/api/users/:id

    @PUT("users/{id}")
    fun updateUser(@Path("id") id: String, @Body user: User): Call<User>

    //    DELETE	https://tutormatch.free.beeceptor.com/api/users/:id

    @DELETE("users/{id}")
    fun deleteUser(@Path("id") id: String): Call<User>

}