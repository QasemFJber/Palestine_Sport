
package com.example.palestinesport.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Playgound {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("playgound_name")
    @Expose
    public String playgoundName;
    @SerializedName("playgound_type")
    @Expose
    public String playgoundType;
    @SerializedName("playgound_address")
    @Expose
    public String playgoundAddress;
    @SerializedName("houre_price")
    @Expose
    public Integer hourePrice;
    @SerializedName("work_houre")
    @Expose
    public String workHoure;
    @SerializedName("coordinator_name")
    @Expose
    public String coordinatorName;
    @SerializedName("coordinator_phone")
    @Expose
    public String coordinatorPhone;
    @SerializedName("longitude")
    @Expose
    public String longitude;
    @SerializedName("latitude")
    @Expose
    public String latitude;

}
