package com.example.palestinesport.api.controller;



import com.example.palestinesport.api.RetrofitRequests;
import com.example.palestinesport.api.RetrofitSettings;


public class ApiController {

    private RetrofitRequests retrofitRequests;
    private static  ApiController instance;

    private ApiController(){
        retrofitRequests = RetrofitSettings.getInstance().create(RetrofitRequests.class);
    }

    public static synchronized ApiController getInstance(){
        if (instance == null){
            instance = new ApiController();
        }
        return instance;
    }

    public RetrofitRequests getRetrofitRequests() {
        return retrofitRequests;
    }
}
