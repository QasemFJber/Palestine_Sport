package com.example.palestinesport.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.palestinesport.R;
import com.example.palestinesport.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        operationsSccren();

        binding.btnPlaygroundReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PlaygroundReservationActivity.class));
            }
        });

        binding.btnDomesticLeague.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MatchScheduleActivity.class));
            }
        });

    }
    private void operationsSccren() {
        setTitle("HOME");
//        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.white)));
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.black));
    }
}