package com.example.palestinesport.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import com.example.palestinesport.R;
import com.example.palestinesport.databinding.ActivityPlaygroundReservationBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class PlaygroundReservationActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;

    private GoogleMap myGoogleMap;
    private UiSettings uiSettings;

    ActivityPlaygroundReservationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlaygroundReservationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_view);
        supportMapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
            this.myGoogleMap = googleMap;

        this.myGoogleMap = googleMap;
        uiSettings = googleMap.getUiSettings();
        // Customize your map options and add markers or other functionalities here

        // Add zoom controls
        uiSettings.setZoomControlsEnabled(true);

        LatLng gaza = new LatLng(31.515573507377145, 34.44048516931093);
        myGoogleMap.addMarker(new MarkerOptions().position(gaza).title("Gaza"));
        myGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(gaza));

        myGoogleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(@NonNull Marker marker) {

                startActivity(new Intent(getApplicationContext(), DatasActivity.class));
                return false;
            }
        });

        myGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(gaza, 11));

        // Request location permission if not granted
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    LOCATION_PERMISSION_REQUEST_CODE);
        } else {
            // Start location updates
//            startLocationUpdates();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, start location updates
                Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
//                startLocationUpdates();
            } else {
                // Permission denied, handle accordingly
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

}