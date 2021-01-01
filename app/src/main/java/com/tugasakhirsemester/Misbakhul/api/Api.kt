package com.tugasakhirsemester.Misbakhul

import com.tugasakhirsemester.Misbakhul.Model.IndonesiaResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("indonesia")
    fun getIndonesia(): Call<ArrayList<IndonesiaResponse>>
}