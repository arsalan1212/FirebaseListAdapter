package com.example.arsalankhan.firebaselistadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Arsalan khan on 5/30/2017.
 */

public class MyAdapter extends BaseAdapter {

    ArrayList<Artist> artists=new ArrayList<>();
    Context context;

    public MyAdapter(Context context,ArrayList<Artist> art){
        artists=art;
        this.context=context;
    }
    @Override
    public int getCount() {
        return artists.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.single_row,parent,false);

        TextView tv_name= (TextView) view.findViewById(R.id.tv_name);
        TextView tv_art= (TextView) view.findViewById(R.id.tv_art);

        Artist artist=artists.get(position);

        tv_name.setText(artist.getName());
        tv_art.setText(artist.getArtist());
        return view;
    }
}
