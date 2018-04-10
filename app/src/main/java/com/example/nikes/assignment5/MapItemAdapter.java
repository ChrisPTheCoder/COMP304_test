package com.example.nikes.assignment5;

import android.content.Context;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/**
 * Created by linhp on 10/04/2018.
 */

public class MapItemAdapter implements GoogleMap.InfoWindowAdapter  {
    LayoutInflater inflater;
    Context context;
    TextView tv;
    int image;
    public MapItemAdapter(Context context, int image) {
        this.image = image;
        this.context = context;
    }


    @Override
    public View getInfoWindow(Marker marker) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.activity_info_window,null);
        ImageView image = v.findViewById(R.id.image);
        image.setImageResource(this.image);
        TextView tv = v.findViewById(R.id.college);
        tv.setText(marker.getTitle());
        TextView tv2 = v.findViewById(R.id.campus);
        tv2.setText(marker.getSnippet());
        return v;
    }


    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }
}
