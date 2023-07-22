package com.example.palestinesport.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.palestinesport.api.controller.MatchesController;
import com.example.palestinesport.databinding.ActivityMatchDataBinding;
import com.example.palestinesport.interfaces.ListCallback;
import com.example.palestinesport.models.Matchas;

import java.util.List;

public class MatchDataActivity extends AppCompatActivity {


    ActivityMatchDataBinding binding;
    MatchesController controller = new MatchesController();
    int id;
    String matchDay,matchDate,team1,team2,matchTime,league,team1_logo,team2_logo,round,refree,pre_match_score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMatchDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Toast.makeText(this, ""+getIntent().getIntExtra("id",0), Toast.LENGTH_SHORT).show();

        id = getIntent().getIntExtra("id", 0);
        controller.getMatchDetail(String.valueOf(id), new ListCallback<Matchas>() {
            @Override
            public void onSuccess(List<Matchas> list) {

                for (int i = 0; i < list.size(); i++) {
                    matchDate = list.get(i).matchDate;
                    matchTime = list.get(i).matchTime;
                    pre_match_score = list.get(i).preMatchScore;
                    team1 = list.get(i).team1;
                    team2 = list.get(i).team2;
                    league = list.get(i).league;

                    binding.tvMatchTime.setText(matchTime);
                    binding.tvTeamName1.setText(team1);
                    binding.tvTeamName2.setText(team2);
                    binding.tvLeague.setText(league);


                }
                Toast.makeText(MatchDataActivity.this, ""+id, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(String message) {
                Toast.makeText(MatchDataActivity.this, ""+message, Toast.LENGTH_SHORT).show();

            }
        });
    }
}