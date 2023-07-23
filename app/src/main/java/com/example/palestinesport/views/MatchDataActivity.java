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

                Toast.makeText(MatchDataActivity.this, ""+list.size(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(String message) {
                Toast.makeText(MatchDataActivity.this, ""+message, Toast.LENGTH_SHORT).show();

            }
        });
    }
}