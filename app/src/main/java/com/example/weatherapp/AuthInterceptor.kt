package com.example.weatherapp

import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

class AuthInterceptor: Interceptor{

    override fun intercept(chain: Interceptor.Chain): Response {
        try{
            var request = chain.request()
            val url = request
                .url
                .newBuilder()
                .addQueryParameter("apikey","C13ggAbA9Z7h7Uab5owyOkEalVYDCNAN")
                .build()
            request = request.newBuilder().url(url).build()
            return chain.proceed(request)
        } catch (e: Exception){
            return Response.Builder()
                .request(chain.request())
                .protocol(Protocol.HTTP_1_1)
                .code(400)
                .message("Client error")
                .body(e.stackTraceToString().toResponseBody("text/plain".toMediaType()))
                .build()

        }
    }
}