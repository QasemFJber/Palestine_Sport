package com.example.palestinesport.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.palestinesport.R;

public class StadiumDataFragment1 extends Fragment {

    public StadiumDataFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (getActivity() != null) {
            int id = getActivity().getIntent().getIntExtra("id", 00);

            Toast.makeText(getContext(), "" + id, Toast.LENGTH_SHORT).show();
        }


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stadium_data1, container, false);
    }
}