package com.example.palestinesport.api;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSettings {

    private static Retrofit retrofit;

    private static  final  String BaseURL = "http://86.48.0.117:8081/playgroundsAPI/public/index.php/api/";

    private RetrofitSettings(){}

    public static synchronized Retrofit getInstance() {
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .client(getClient())
                    .baseUrl(BaseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit ;
    }

    private static OkHttpClient getClient(){
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request.Builder builder = chain.request().newBuilder();
                builder.addHeader("Accept","application/json");
                builder.addHeader("Content-Type","application/json");
                //builder.addHeader("Authorization", AppSharedPreferences.getInstance(AppController.getInstance()).getToKen());
                return chain.proceed(builder.build());

            }
        }).build();
        return client;
    }

}
