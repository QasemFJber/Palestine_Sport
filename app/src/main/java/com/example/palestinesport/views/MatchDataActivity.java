package com.example.palestinesport.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.palestinesport.R;
import com.example.palestinesport.databinding.ActivityMatchDataBinding;

public class MatchDataActivity extends AppCompatActivity {


    ActivityMatchDataBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMatchDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}