package com.example.palestinesport.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.palestinesport.R;
import com.example.palestinesport.databinding.FragmentStadiumData1Binding;

public class StadiumDataFragment1 extends Fragment {

    FragmentStadiumData1Binding binding;
    Intent intent;
    public StadiumDataFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentStadiumData1Binding.inflate(inflater,container,false);
//        intent = new Intent();

        if (getActivity() != null) {
            int id = getActivity().getIntent().getIntExtra("id", 00);

            Toast.makeText(getContext(), "" + id, Toast.LENGTH_SHORT).show();
        }

        String name = getActivity().getIntent().getStringExtra("playgroundName");
            binding.txtPlaygroundName.setText(name);



        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}