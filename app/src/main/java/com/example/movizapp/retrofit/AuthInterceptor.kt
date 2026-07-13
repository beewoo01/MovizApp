package com.example.movizapp.retrofit

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val newRequest = originalRequest.newBuilder()
            .header("Accept", "application/json")
            .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyYWMxYjRlYjUxZjljYmZiYWRkMjQ1NzVmOTIzYTI4ZiIsIm5iZiI6MTc4MzQ4MTAxNS44OTUsInN1YiI6IjZhNGRjMmI3ODU2ZmM3MmE1MWY5MDI3NCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.7pBIAvK4Ak35bnoLQ-OdLPlaBSKRhyENTaZN1sWhEfA")
            .build()

        return chain.proceed(newRequest)
    }

}