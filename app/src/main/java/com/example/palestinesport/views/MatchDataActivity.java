package com.example.palestinesport.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.palestinesport.R;
import com.example.palestinesport.api.controller.MatchesController;
import com.example.palestinesport.databinding.ActivityMatchDataBinding;
import com.example.palestinesport.interfaces.ListCallback;
import com.example.palestinesport.models.Matchas;

import java.util.List;

public class MatchDataActivity extends AppCompatActivity {


    ActivityMatchDataBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMatchDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Toast.makeText(this, ""+getIntent().getIntExtra("id",0), Toast.LENGTH_SHORT).show();

        MatchesController controller = new MatchesController();
        controller.getMatchDetail(String.valueOf(getIntent().getIntExtra("id", 0)), new ListCallback<Matchas>() {
            @Override
            public void onSuccess(List<Matchas> list) {

                //Toast.makeText(MatchDataActivity.this, ""+list.size(), Toast.LENGTH_SHORT).show();

                binding.tvTeamName1.setText(list.get(0).team1);
                binding.tvTeamName2.setText(list.get(0).team2);
                binding.tvCountdown.setText(list.get(0).matchTime);
                binding.tvTimer.setText(String.valueOf(list.get(0).matchDate));
                binding.tvMatchTime.setText(String.valueOf(list.get(0).matchDate));
                binding.tvLeague.setText(list.get(0).league);
                binding.tvLeagueTour.setText(list.get(0).round);
                binding.tvRefereeName.setText(list.get(0).refree);
                binding.tvPitch.setText(list.get(0).playgropund.get(0).playgoundName);
                binding.tvResult.setText(list.get(0).preMatchScore);

            }

            @Override
            public void onFailure(String message) {
                Toast.makeText(MatchDataActivity.this, ""+message, Toast.LENGTH_SHORT).show();

            }
        });
    }
}