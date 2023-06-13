package com.example.palestinesport.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.palestinesport.R;
import com.example.palestinesport.databinding.ActivityPlaygroundReservationBinding;

public class PlaygroundReservationActivity extends AppCompatActivity {

    ActivityPlaygroundReservationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlaygroundReservationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}