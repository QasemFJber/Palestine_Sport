package com.example.palestinesport.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.palestinesport.R;
import com.example.palestinesport.adapter.MyFragmentAdapter;
import com.example.palestinesport.databinding.ActivityDatasBinding;

public class DatasActivity extends AppCompatActivity {

    ActivityDatasBinding binding;
    MyFragmentAdapter adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDatasBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        adapter = new MyFragmentAdapter(this);

        binding.pager.setAdapter(adapter);

       // binding.pager.addItemDecoration(R.layout.fragment_stadium_data1,1);
    }
}