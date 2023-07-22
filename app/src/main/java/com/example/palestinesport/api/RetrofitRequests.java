package com.example.palestinesport.api;


import com.example.palestinesport.models.BaseResponse;
import com.example.palestinesport.models.Matchas;
import com.example.palestinesport.models.Playgound;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;



public interface RetrofitRequests {

    @POST("getAllplaygrounds")
    Call<BaseResponse<Playgound>> getAllplaygrounds();


    //@Multipart
    @FormUrlEncoded
    @POST("getPlaygroundDetail")
    Call<BaseResponse<Playgound>> getPlaygroundDetail(@Field("playground_id") String playground_id);


    @POST("getAllMatches")
    Call<BaseResponse<Matchas>> getAllMatches();

   // @Multipart
    @FormUrlEncoded
    @POST("getMatchDetail")
    Call<BaseResponse<Matchas>> getMatchDetail(@Field("match_id") String match_id);



}
