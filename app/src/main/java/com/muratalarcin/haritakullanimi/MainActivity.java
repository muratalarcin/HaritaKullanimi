package com.muratalarcin.haritakullanimi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.muratalarcin.haritakullanimi.databinding.ActivityMainBinding;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        binding.buttonKonumaGit.setOnClickListener(view -> {
            //41.0370175,28.974792,15z
            LatLng konum = new LatLng(41.0370175, 28.974792);
            mMap.addMarker(new MarkerOptions().position(konum).title("Taksim"))//işaretçi
                    .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.token_img));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(konum, 17f));//kamerayı ortala
            mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        });

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Sydney"));//işaretçi
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));//kamerayı ortala
    }
}