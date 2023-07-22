package com.example.palestinesport.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.palestinesport.R;
import com.example.palestinesport.adapter.MatchAdapter;
import com.example.palestinesport.api.controller.MatchesController;
import com.example.palestinesport.api.controller.PlaygoundController;
import com.example.palestinesport.databinding.ActivityMatchScheduleBinding;
import com.example.palestinesport.interfaces.ItemOnClick;
import com.example.palestinesport.interfaces.ListCallback;
import com.example.palestinesport.models.Matchas;
import com.example.palestinesport.models.Playgound;

import java.util.ArrayList;
import java.util.List;

public class MatchScheduleActivity extends AppCompatActivity implements ItemOnClick {
    ActivityMatchScheduleBinding binding;

    List<Matchas> matchas = new ArrayList<>();
    MatchAdapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMatchScheduleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());







        binding.tabDay.addTab(binding.tabDay.newTab().setText("الخميس"));
        binding.tabDay.addTab(binding.tabDay.newTab().setText("الاربعاء"));
        binding.tabDay.addTab(binding.tabDay.newTab().setText("الثلاثاء"));
        binding.tabDay.addTab(binding.tabDay.newTab().setText("الاثنين"));
        binding.tabDay.addTab(binding.tabDay.newTab().setText("الاحد"));
        binding.tabDay.addTab(binding.tabDay.newTab().setText("السبت"),true);


        adapter = new MatchAdapter(matchas);
        adapter.setItemOnClick(this::onItemClick);
        binding.recMatch.setAdapter(adapter);
        binding.recMatch.setLayoutManager(new LinearLayoutManager(getApplicationContext()));



        MatchesController controller = new MatchesController();
        controller.getAllMatches(new ListCallback<Matchas>() {
            @Override
            public void onSuccess(List<Matchas> list) {
                matchas.addAll(list);
                adapter.notifyDataSetChanged();
                //Toast.makeText(MatchScheduleActivity.this, ""+list.size(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(String message) {
                Toast.makeText(MatchScheduleActivity.this, ""+message, Toast.LENGTH_SHORT).show();

            }
        });


    }

    @Override
    public void onItemClick(int id) {
        Intent intent =new Intent(getApplicationContext(), MatchDataActivity.class);
        intent.putExtra("id",id);
        startActivity(intent);

    }
}