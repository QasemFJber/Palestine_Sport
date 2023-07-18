package com.example.palestinesport.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.palestinesport.R;


public class StadiumDataFragment2 extends Fragment {

    Intent intent;

    public StadiumDataFragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        intent = new Intent();

        if (intent.hasExtra("id")){
            Toast.makeText(getContext(), ""+intent.getIntExtra("id",00), Toast.LENGTH_SHORT).show();
        }

        return inflater.inflate(R.layout.fragment_stadium_data2, container, false);

    }
}