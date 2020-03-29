package com.tylerb.network

import com.tylerb.model.ScriptureResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GetScripture {

    @GET("content")
    suspend fun getBook(
        @Query("lang") lang: String,
        @Query("uri") scripture: String
    ) : ScriptureResponse

}