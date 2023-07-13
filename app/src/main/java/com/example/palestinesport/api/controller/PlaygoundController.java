package com.example.palestinesport.api.controller;

import android.util.Log;

import com.example.palestinesport.interfaces.ListCallback;
import com.example.palestinesport.models.BaseResponse;
import com.example.palestinesport.models.Playgound;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlaygoundController {


    public void getPaygound(ListCallback<Playgound> callback){
        Call<BaseResponse<Playgound>> call=ApiController.getInstance().getRetrofitRequests().getAllplaygrounds();

        call.enqueue(new Callback<BaseResponse<Playgound>>() {
            @Override
            public void onResponse(Call<BaseResponse<Playgound>> call, Response<BaseResponse<Playgound>> response) {
                if (response.isSuccessful() && response.body() != null){
                    callback.onSuccess(response.body().data);
                }else {
                    callback.onFailure("No data");
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<Playgound>> call, Throwable t) {
                callback.onFailure("no value");

            }
        });

    }


    public void getPlaygroundDetail(String playground_id,ListCallback<Playgound> callback){
        Call<BaseResponse<Playgound>> call = ApiController.getInstance().getRetrofitRequests().getPlaygroundDetail(playground_id);

        call.enqueue(new Callback<BaseResponse<Playgound>>() {
            @Override
            public void onResponse(Call<BaseResponse<Playgound>> call, Response<BaseResponse<Playgound>> response) {
                if (response.isSuccessful()){
                    callback.onSuccess(response.body().data);
                }else {
                    callback.onFailure("No Data");
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<Playgound>> call, Throwable t) {
                callback.onFailure("");

            }
        });
    }



}
