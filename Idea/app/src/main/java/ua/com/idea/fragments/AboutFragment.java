package ua.com.idea.fragments;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import ua.com.idea.R;
import ua.com.idea.views.MapViewForScroll;


/**
 * Created by cheb on 7/18/15.
 */
public class AboutFragment extends Fragment implements View.OnClickListener {
    private MapViewForScroll mapView;
    private GoogleMap map;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_about, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapView = (MapViewForScroll) view.findViewById(R.id.mapview);
        mapView.onCreate(savedInstanceState);

        // Gets to GoogleMap from the MapView and does initialization stuff
        map = mapView.getMap();
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
//                CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(49.1, 26.9), 10);
//                map.animateCamera(cameraUpdate);
                //Calculate the markers to get their position
                ArrayList<Marker> markers = new ArrayList<Marker>();
                markers.add(map.addMarker(new MarkerOptions().position(new LatLng(49.4404149, 32.0380944))));
                markers.add(map.addMarker(new MarkerOptions().position(new LatLng(48.9117518, 24.6470891))));
                markers.add(map.addMarker(new MarkerOptions().position(new LatLng(49.8326679, 23.9421957))));
                LatLngBounds.Builder b = new LatLngBounds.Builder();
                for (Marker m : markers) {
                    b.include(m.getPosition());
                }
                LatLngBounds bounds = b.build();
                //Change the padding as per needed
                CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, 15, 15, 3);

                map.animateCamera(cu);
            }
        });

        view.findViewById(R.id.txt_skype).setOnClickListener(this);
        view.findViewById(R.id.txt_phone).setOnClickListener(this);
        view.findViewById(R.id.txt_web).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txt_skype:
                try {
                    Intent sky = new Intent("android.intent.action.VIEW");
                    sky.setData(Uri.parse("skype:" + getString(R.string.skype_number)));
                    Log.d("UTILS", "tel:" + getString(R.string.skype_number));
                    getActivity().startActivity(sky);
                } catch (ActivityNotFoundException e) {
                    Log.e("SKYPE CALL", "Skype failed", e);
                }
                break;
            case R.id.txt_phone:
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + getResources().getString(R.string.phone_val)));
                startActivity(intent);
                break;
            case R.id.txt_web:
                String url = getResources().getString(R.string.site_val_for_intent);
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                break;
        }
    }

    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

}
