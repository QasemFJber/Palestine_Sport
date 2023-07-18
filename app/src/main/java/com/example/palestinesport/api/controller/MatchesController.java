package com.example.palestinesport.api.controller;

import com.example.palestinesport.interfaces.ListCallback;
import com.example.palestinesport.models.BaseResponse;
import com.example.palestinesport.models.Matchas;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatchesController {


    public void getAllMatches(ListCallback<Matchas> callback){
        Call<BaseResponse<Matchas>> call= ApiController.getInstance().getRetrofitRequests().getAllMatches();
        call.enqueue(new Callback<BaseResponse<Matchas>>() {
            @Override
            public void onResponse(Call<BaseResponse<Matchas>> call, Response<BaseResponse<Matchas>> response) {
                if (response.isSuccessful() && response.body() != null){
                    callback.onSuccess(response.body().data);
                }else {
                    callback.onFailure(response.message());
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<Matchas>> call, Throwable t) {
                callback.onFailure("");

            }
        });
    }

    public void getMatchDetail(String match_id,ListCallback<Matchas> callback){
        Call<BaseResponse<Matchas>> call = ApiController.getInstance().getRetrofitRequests().getMatchDetail(match_id);
        call.enqueue(new Callback<BaseResponse<Matchas>>() {
            @Override
            public void onResponse(Call<BaseResponse<Matchas>> call, Response<BaseResponse<Matchas>> response) {
                if (response.isSuccessful() && response.body() !=null){
                    callback.onSuccess(response.body().data);
                }else {
                    callback.onFailure(response.message());
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<Matchas>> call, Throwable t) {
                callback.onFailure("");

            }
        });
    }
}
