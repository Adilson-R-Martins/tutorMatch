package com.tutormatch.service

import com.tutormatch.model.Skill
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface SkillService {

    //    BASE_URL  https://tutormatch.free.beeceptor.com/api/


    //    GET	https://tutormatch.free.beeceptor.com/api/skill

    @GET("skill")
    fun getAllSkill(): Call<List<Skill>>

    @GET("skill/{id}?skill={skill}")
    fun searchUserBySkill(@Path("id") id: String, @Query("skill") skill: String): Call<List<Skill>>

    //    POST	https://tutormatch.free.beeceptor.com/api/skill

    @POST("skill")
    fun createSkill(@Body skill: Skill): Call<Skill>

    //    PUT	https://tutormatch.free.beeceptor.com/api/skill/:id

    @PUT("skill/{id}")
    fun updateSkill(@Path("id") id: String, @Body skill: Skill): Call<Skill>

    //    DELETE	https://tutormatch.free.beeceptor.com/api/users/:id

    @DELETE("skill/{id}")
    fun deleteSkill(@Path("id") id: String): Call<Skill>

}