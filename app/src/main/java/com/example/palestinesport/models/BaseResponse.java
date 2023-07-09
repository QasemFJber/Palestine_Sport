
package com.example.palestinesport.models;

import android.graphics.ColorSpace;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseResponse<Model> {

    @SerializedName("status")
    @Expose
    public Boolean status;
    @SerializedName("errNum")
    @Expose
    public Integer errNum;
    @SerializedName("msg")
    @Expose
    public String msg;
    @SerializedName("RecordsTotal")
    @Expose
    public Integer recordsTotal;
    @SerializedName("data")
    @Expose
    public List<Model> data = null;
}
