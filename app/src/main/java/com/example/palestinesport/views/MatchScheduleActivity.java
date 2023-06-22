package com.example.palestinesport.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.palestinesport.R;
import com.example.palestinesport.databinding.ActivityMatchScheduleBinding;

public class MatchScheduleActivity extends AppCompatActivity {
    ActivityMatchScheduleBinding binding;

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



    }
}