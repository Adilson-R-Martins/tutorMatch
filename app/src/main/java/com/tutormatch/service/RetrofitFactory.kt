package com.tutormatch.service

import com.tutormatch.model.WorkExperience
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    private val URL = "https://tutormatch.free.beeceptor.com/api/"

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getCertificateService(): CertificateService {
        return retrofitFactory.create(CertificateService::class.java)
    }

    fun getInterestService(): InterestService {
        return retrofitFactory.create(InterestService::class.java)
    }

    fun getQualificationService(): QualificationService {
        return retrofitFactory.create(QualificationService::class.java)
    }

    fun getReviewService(): ReviewService {
        return retrofitFactory.create(ReviewService::class.java)
    }

    fun getSkillService(): SkillService {
        return retrofitFactory.create(SkillService::class.java)
    }

    fun getUserService(): UserService {
        return retrofitFactory.create(UserService::class.java)
    }

    fun getWorkExperienceService(): WorkExperience {
        return retrofitFactory.create(WorkExperience::class.java)
    }
}