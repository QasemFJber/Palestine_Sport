
package com.example.palestinesport.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Matchas {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("match_day")
    @Expose
    public String matchDay;
    @SerializedName("match_date")
    @Expose
    public String matchDate;
    @SerializedName("team1")
    @Expose
    public String team1;
    @SerializedName("team2")
    @Expose
    public String team2;
    @SerializedName("match_time")
    @Expose
    public String matchTime;
    @SerializedName("league")
    @Expose
    public String league;
    @SerializedName("team1_logo")
    @Expose
    public String team1Logo;
    @SerializedName("team2_logo")
    @Expose
    public String team2Logo;
    @SerializedName("round")
    @Expose
    public String round;
    @SerializedName("refree")
    @Expose
    public String refree;
    @SerializedName("playground_id")
    @Expose
    public Integer playgroundId;
    @SerializedName("pre_match_score")
    @Expose
    public String preMatchScore;
    @SerializedName("playgropund")
    @Expose
    public List<Playgound> playgropund;

}
