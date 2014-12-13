package com.n.carapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jpapp_000 on 12/7/2014.
 */
/*public class YouTubeListViewAdapter extends BaseAdapter {

    // Declare Variables
    Context context;
    LayoutInflater inflater;
    private List<CarInfo> carlist = null;
    private ArrayList<CarInfo> arraylist;

    public YouTubeListViewAdapter(Context context,
                           List<CarInfo> carlist) {
        this.context = context;
        this.carlist = carlist;
        inflater = LayoutInflater.from(context);
        this.arraylist = new ArrayList<CarInfo>();
        this.arraylist.addAll(carlist);
    }

    public class ViewHolder {
        TextView brand;
        TextView model;
    }

    @Override
    public int getCount() {
        return carlist.size();
    }

    @Override
    public Object getItem(int position) {
        return carlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.youtubelistviewitem, null);
            // Locate the TextViews in listview_item.xml
            holder.brand = (TextView) view.findViewById(R.id.youtube_brand);
            holder.model = (TextView) view.findViewById(R.id.youtube_model);

            // Locate the ImageView in listview_item.xml
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.brand.setText(carlist.get(position).getBrand());
        holder.model.setText(carlist.get(position).getModel());


        // Listen for ListView Item Click
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Send single item click data to SingleItemView Class
                Intent intent = new Intent(context, YoutubeFragment.class);

                intent.putExtra("brand",
                        (carlist.get(position).getBrand()));

                intent.putExtra("model",
                        (carlist.get(position).getModel()));

                intent.putExtra("video", (carlist.get(position).getVideoID()));

                // Start SingleItemView Class
                context.startActivity(intent);



            }
        });
        return view;
    }

}*/
