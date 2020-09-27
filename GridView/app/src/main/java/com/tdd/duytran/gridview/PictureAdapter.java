package com.tdd.duytran.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

public class PictureAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Picture> pictureList;

    public PictureAdapter(Context context, int layout, List<Picture> pictureList) {
        this.context = context;
        this.layout = layout;
        this.pictureList = pictureList;
    }

    @Override
    public int getCount() {
        return pictureList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        ImageView imgPicture;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null) {
            holder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(layout, null);
            holder.imgPicture = (ImageView) convertView.findViewById(R.id.imageViewPicture);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Picture picture = pictureList.get(position);
        holder.imgPicture.setImageResource(picture.getPicture());
        return convertView;
    }
}
