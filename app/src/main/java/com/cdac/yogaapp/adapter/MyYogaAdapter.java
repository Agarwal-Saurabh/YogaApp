package com.cdac.yogaapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.cdac.yogaapp.R;
import com.cdac.yogaapp.helper.DownloadHelper;
import com.cdac.yogaapp.pojo.YogaListPojo;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class MyYogaAdapter extends ArrayAdapter<YogaListPojo> {
    Context context;
    int resource;
    ArrayList<YogaListPojo> arrayList;
    LayoutInflater layoutInflater;

    public MyYogaAdapter(Context context, int resource, ArrayList<YogaListPojo> objects) {
        super(context, resource, objects);
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        this.context = context;
        this.resource = resource;
        this.arrayList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = layoutInflater.inflate(resource, null);

        TextView tv = (TextView) view.findViewById(R.id.txtView);

        CircleImageView imageView = (CircleImageView) view.findViewById(R.id.imageView1);


        YogaListPojo pojo = arrayList.get(position);

        tv.setText(pojo.getCategory());

        DownloadHelper.loadImageWithGlideURL(context, pojo.getImg(), imageView);
        return view;
    }
}
