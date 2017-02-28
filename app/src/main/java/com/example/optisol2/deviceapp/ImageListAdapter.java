package com.example.optisol2.deviceapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by optisol2 on 19-01-2017.
 */
public class ImageListAdapter extends ArrayAdapter {
    private Context context;
    private LayoutInflater inflater;

    private Integer[] imageUrls;

    public ImageListAdapter(Context context, Integer[] imageUrls) {
        super(context,R.layout.list_view, imageUrls);

        this.context = context;
        this.imageUrls = imageUrls;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null == convertView) {
            convertView = inflater.inflate(R.layout.list_view, parent, false);
        }
        ImageView img=(ImageView)convertView.findViewById(R.id.imageView1);

        Glide.with(context).load(imageUrls[position]).placeholder(R.drawable.ac).centerCrop().into(img);

        return convertView;
    }
}
