package com.example.palestinesport.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.palestinesport.api.controller.PlaygoundController;
import com.example.palestinesport.databinding.FragmentStadiumData1Binding;
import com.example.palestinesport.interfaces.ListCallback;
import com.example.palestinesport.models.Playgound;

import java.util.List;

public class StadiumDataFragment1 extends Fragment {

    FragmentStadiumData1Binding binding;
    String playgroundName ,playgroundType,playgroundAddress;
    int hourPrice,id;
    PlaygoundController controller = new PlaygoundController();
    public StadiumDataFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentStadiumData1Binding.inflate(inflater,container,false);

        if (getActivity() != null) {
            id = getActivity().getIntent().getIntExtra("id", 00);

//            Toast.makeText(getContext(), "" + id, Toast.LENGTH_SHORT).show();
        }


        controller.getPlaygroundDetail(String.valueOf(id), new ListCallback<Playgound>() {
            @Override
            public void onSuccess(List<Playgound> list) {
                for (int i = 0; i < list.size(); i++) {
                    playgroundName = list.get(i).playgoundName;
                    playgroundType = list.get(i).playgoundType;
                    playgroundAddress = list.get(i).playgoundAddress;
                    hourPrice = list.get(i).hourePrice;

                    binding.txtPlaygroundName.setText(playgroundName);
                    binding.txtPlaygroundType.setText(playgroundType);
                    binding.txtPlaygroundAddress.setText(playgroundAddress);
                    binding.txtHourePrice.setText(""+hourPrice);
                }
            }

            @Override
            public void onFailure(String message) {
                Toast.makeText(getActivity(), "no Internet Connection", Toast.LENGTH_SHORT).show();
            }
        });


        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}