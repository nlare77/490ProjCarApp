package com.n.carapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.n.carapp.R;
import com.n.carapp.activity.SingleItemView;
import com.n.carapp.core.CarInfo;
import com.n.carapp.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nick7 on 11/30/2014.
 */
public class ListViewAdapter extends BaseAdapter {

    // Declare Variables
    Context context;
    LayoutInflater inflater;
    ImageLoader imageLoader;
    private List<CarInfo> carinfolist = null;
    private ArrayList<CarInfo> arraylist;

    public ListViewAdapter(Context context,
                           List<CarInfo> carinfolist) {
        this.context = context;
        this.carinfolist = carinfolist;
        inflater = LayoutInflater.from(context);
        this.arraylist = new ArrayList<CarInfo>();
        this.arraylist.addAll(carinfolist);
        imageLoader = new ImageLoader(context);
    }

    public class ViewHolder {
        TextView brand;
        TextView model;



        ImageView carImage;
    }

    @Override
    public int getCount() {
        return carinfolist.size();
    }

    @Override
    public Object getItem(int position) {
        return carinfolist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.listview_item, null);

            holder.brand = (TextView) view.findViewById(R.id.brand);
            holder.model = (TextView) view.findViewById(R.id.model);





            holder.carImage = (ImageView) view.findViewById(R.id.carImage);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.brand.setText(carinfolist.get(position).getBrand());
        holder.model.setText(carinfolist.get(position).getModel());



        // Set the results into ImageView
        imageLoader.DisplayImage(carinfolist.get(position).getCarImage(),
                holder.carImage);
        // Listen for ListView Item Click
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Send single item click data to SingleItemView Class
                Intent intent = new Intent(context, SingleItemView.class);
                //Intent youtubeintent = new Intent(context, YoutubeFragment.class);

                intent.putExtra("brand",
                        (carinfolist.get(position).getBrand()));

                intent.putExtra("model",
                        (carinfolist.get(position).getModel()));

                intent.putExtra("engine",
                        (carinfolist.get(position).getEngine()));
                intent.putExtra("sixtyTime",
                        (carinfolist.get(position).getSixtyTime()));
                intent.putExtra("topSpeed",
                        (carinfolist.get(position).getTopSpeed()));

                // Pass all data
                intent.putExtra("car image",
                        (carinfolist.get(position).getCarImage()));

                intent.putExtra("video", (carinfolist.get(position).getVideoID()));

                // Start SingleItemView Class
                context.startActivity(intent);







            }
        });
        return view;
    }

}