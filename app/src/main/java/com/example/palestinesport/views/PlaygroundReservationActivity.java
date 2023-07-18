package com.example.palestinesport.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationRequest;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.palestinesport.R;
import com.example.palestinesport.api.controller.PlaygoundController;
import com.example.palestinesport.databinding.ActivityPlaygroundReservationBinding;
import com.example.palestinesport.interfaces.ListCallback;
import com.example.palestinesport.models.Playgound;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;


public class PlaygroundReservationActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;

    private GoogleMap myGoogleMap;
    private UiSettings uiSettings;
    String lt;
    String lo;
    LatLng gaza1;
    Marker marker;
    int id;
    List<Playgound> playgoundList = new ArrayList<>();
    PlaygoundController controller = new PlaygoundController();

    ActivityPlaygroundReservationBinding binding;
    List<Marker> markers = new ArrayList<>();

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
        uiSettings = googleMap.getUiSettings();
        // Customize your map options and add markers or other functionalities here


        // Add zoom controls
        uiSettings.setZoomControlsEnabled(true);
//        LatLng gaza = new LatLng(31.515573507377145, 34.44048516931093);


        controller.getPaygound(new ListCallback<Playgound>() {
            @Override
            public void onSuccess(List<Playgound> list) {
                // Log.d("TAGAA", "onSuccess: "+list);
                playgoundList.addAll(list);

                LatLng unRemovable = new LatLng(31.506055035497482, 34.46641396462059);
                myGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(unRemovable, 11));
                myGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(unRemovable));

                for (int i = 0; i < playgoundList.size(); i++) {
//                    lo = playgoundList.get(i).longitude;
//                    lt = playgoundList.get(i).latitude;
//                    Log.d("aaa", "onMapReady:" + lt);

                    try {
                        gaza1 = new LatLng(Double.parseDouble(playgoundList.get(i).longitude), Double.parseDouble(playgoundList.get(i).latitude));
                        marker = myGoogleMap.addMarker(new MarkerOptions().position(gaza1).title(playgoundList.get(i).playgoundName));
//                        markers.add(marker);
                    } catch (NumberFormatException exception) {
                        Toast.makeText(PlaygroundReservationActivity.this, "" + exception, Toast.LENGTH_SHORT).show();
                    }


                    int finalI = i;
                    myGoogleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                        @Override
                        public boolean onMarkerClick(@NonNull Marker marker) {
                            Intent intent = new Intent(getApplicationContext(), DatasActivity.class);
//                            marker.getId();

                            intent.putExtra("id", playgoundList.get(finalI).id);
//                            startActivity(intent);
                            Toast.makeText(PlaygroundReservationActivity.this, "Title must be Showed"+playgoundList.get(finalI).id, Toast.LENGTH_SHORT).show();
                            return false;
                        }
                    });



                    myGoogleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                        @Override
                        public void onMapClick(@NonNull LatLng latLng) {
                                // Launch the new activity with marker ID
//                                Intent intent = new Intent(getApplicationContext(), DatasActivity.class);
//                                marker.getId();

//                                intent.putExtra("id", playgoundList.get(finalI).id);
//                                startActivity(intent);
//                            if (marker != null) {
//                            }
                            marker = null;
                        }
                    });

                }

            }

            @Override
            public void onFailure(String message) {

            }
        });

        binding.locations.setOnClickListener(v -> {
            for (Marker marker1 : markers){
                String title = marker1.getTitle();
                Toast.makeText(this, ""+title, Toast.LENGTH_SHORT).show();
            }
        });

//        myGoogleMap.addMarker(new MarkerOptions().position(gaza1).title("Yarmouk Stadium"));


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


    private void getAllPlatgrounds() {

    }

}