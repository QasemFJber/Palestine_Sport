package com.example.palestinesport.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.palestinesport.R;
import com.example.palestinesport.databinding.ActivityPlaygroundReservationBinding;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;


public class PlaygroundReservationActivity extends AppCompatActivity implements OnMapReadyCallback {


    private MapView mapView;
    private GoogleMap googleMap;
//    private TomtomMap tomtomMap;
    ActivityPlaygroundReservationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlaygroundReservationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



//        binding.mapView.
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
            this.googleMap = googleMap;

    }


}