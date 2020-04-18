package com.example.mutabaahamal.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mutabaahamal.Model.AmalanLatest;
import com.example.mutabaahamal.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AmalanAdapterr extends BaseAdapter {

    private Context context;
    private List<AmalanLatest> amalanLatestList;

    public AmalanAdapterr(Context context, List<AmalanLatest> amalanLatestList) {
        this.context = context;
        this.amalanLatestList = amalanLatestList;
    }

    @Override
    public int getCount() {
        return amalanLatestList.size();
    }

    @Override
    public Object getItem(int i) {
        return amalanLatestList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View rowView = view;
        if(rowView==null)
        {
            rowView = LayoutInflater.from(context).inflate(R.layout.layut_item,null);
            TextView name = (TextView)rowView.findViewById(R.id.label);
            ImageView imageView = (ImageView)rowView.findViewById(R.id.image);

            Picasso.get().load(amalanLatestList.get(i).getImage()).into(imageView);
            name.setText(amalanLatestList.get(i).getName());

        }
        return rowView;
    }
}
