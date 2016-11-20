package com.iit.sramaraj.tradeforfun;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Nivash on 11/19/2016.
 */
public class LeaderAdapter extends ArrayAdapter<String> {
    Context mContext;
    int resource;
    ArrayList<String> data = null;
    int pics[] = null;

    public LeaderAdapter(Context context, int resource,ArrayList<String> data, int []pics) {
        super(context, resource,data);
        this.resource = resource;
        this.mContext = context;
        this.data = data;
        this.pics = pics;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            // inflate the layout
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(resource, parent, false);
        }

        // object item based on the position

        int pic = pics[0];

        // get the TextView and then set the text (item name) and tag (item ID) values

        ImageView imageView = (ImageView) convertView.findViewById(R.id.image1);
        imageView.setBackgroundResource(pic);
        TextView textViewItem = (TextView) convertView.findViewById(R.id.noticetitle);

        textViewItem.setText(data.get(position));
        //textViewItem.setTag(objectItem);

        return convertView;

    }
}


