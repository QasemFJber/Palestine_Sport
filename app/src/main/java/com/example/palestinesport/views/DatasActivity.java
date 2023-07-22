package com.example.palestinesport.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.palestinesport.adapter.MyFragmentAdapter;
import com.example.palestinesport.databinding.ActivityDatasBinding;


public class DatasActivity extends AppCompatActivity {

    ActivityDatasBinding binding;
    MyFragmentAdapter adapter;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDatasBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        adapter = new MyFragmentAdapter(this);

        binding.pager.setAdapter(adapter);

        intent = new Intent();
        int id = intent.getIntExtra("id", 0);
        if (intent.hasExtra("id")) {
            Toast.makeText(this, "" + id, Toast.LENGTH_SHORT).show();
        }


    }
}