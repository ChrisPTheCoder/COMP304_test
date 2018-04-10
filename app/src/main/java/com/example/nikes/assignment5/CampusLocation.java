package com.example.nikes.assignment5;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class CampusLocation extends FragmentActivity implements OnMapReadyCallback,GoogleMap.OnInfoWindowClickListener {

    private GoogleMap mMap;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campus_location);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Intent i = getIntent();
        name = i.getStringExtra("name");
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //if(name == "Progress Campus") {
        float zoomLevel = 16.0f;
        final LatLng progress = new LatLng(43.7842, -79.2286);
        mMap.addMarker(new MarkerOptions().position(progress).title("Centennial").snippet("Progress\n941 Progress Ave\n Toronto ON M1G3T8"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(progress, zoomLevel));
        //}
        mMap.setOnInfoWindowClickListener(this);
        mMap.setInfoWindowAdapter(new MapItemAdapter(this, R.drawable.centennial));
    }
        @Override
        public void onInfoWindowClick(Marker marker) {
            Toast.makeText(this, "Info window clicked",
                    Toast.LENGTH_SHORT).show();
        }
    }

