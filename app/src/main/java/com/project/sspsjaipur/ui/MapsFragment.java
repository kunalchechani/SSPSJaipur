package com.project.sspsjaipur.ui;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.project.sspsjaipur.R;

public class MapsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_maps, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(@NonNull GoogleMap googleMap) {
                    LatLng schoolLocation = new LatLng(26.911411, 75.807944);
                    googleMap.addMarker(new MarkerOptions()
                            .position(schoolLocation)
                            .title("St. Soldier Public School"));
                    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(schoolLocation, 15f));

                    // Enable zoom controls
                    googleMap.getUiSettings().setZoomControlsEnabled(true);

                    // Enable compass
                    googleMap.getUiSettings().setCompassEnabled(true);

                    // Set the map type (optional)
                    googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL); // Or MAP_TYPE_SATELLITE, MAP_TYPE_HYBRID, etc.
                }
            });
        }

        return view;
    }
}