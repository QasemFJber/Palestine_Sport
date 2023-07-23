package com.example.palestinesport.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.palestinesport.api.controller.PlaygoundController;
import com.example.palestinesport.databinding.FragmentStadiumData2Binding;
import com.example.palestinesport.interfaces.ListCallback;
import com.example.palestinesport.models.Playgound;

import java.util.List;


public class StadiumDataFragment2 extends Fragment {

    Intent intent;
    PlaygoundController controller = new PlaygoundController();
    String coordinatorName,coordinatorPhone,workHours;
    FragmentStadiumData2Binding binding;
    int id;
    public StadiumDataFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentStadiumData2Binding.inflate(inflater,container,false);
        intent = new Intent();

        id = getActivity().getIntent().getIntExtra("id",00);

        if (intent.hasExtra("id")){
            Toast.makeText(getContext(), ""+id, Toast.LENGTH_SHORT).show();
        }

        controller.getPlaygroundDetail(String.valueOf(id), new ListCallback<Playgound>() {
            @Override
            public void onSuccess(List<Playgound> list) {
                for (int i = 0; i < list.size(); i++) {
                    coordinatorName = list.get(i).coordinatorName;
                    coordinatorPhone = list.get(i).coordinatorPhone;
                    workHours = list.get(i).workHoure;

                    binding.txtCoordinatorName.setText(coordinatorName);
                    binding.txtCoordinatorPhone.setText(coordinatorPhone);
                    binding.txtWorkHour.setText(workHours);
                }
            }

            @Override
            public void onFailure(String message) {
                Toast.makeText(getActivity(), "no Internet Connection", Toast.LENGTH_SHORT).show();
            }
        });


        return binding.getRoot();

    }
}