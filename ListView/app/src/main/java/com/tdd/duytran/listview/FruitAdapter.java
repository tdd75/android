package com.tdd.duytran.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FruitAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Fruit> fruitList;

    public FruitAdapter(Context context, int layout, ArrayList<Fruit> fruitList) {
        this.context = context;
        this.layout = layout;
        this.fruitList = fruitList;
    }

    @Override
    public int getCount() {
        return fruitList.size();
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
        TextView txtName, txtDescription;
        ImageView imgFruit;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();

        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(layout, null);
            // mapping view
            holder.txtName = (TextView) convertView.findViewById(R.id.textName);
            holder.txtDescription = (TextView) convertView.findViewById(R.id.textDescription);
            holder.imgFruit = (ImageView) convertView.findViewById(R.id.imageFruit);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // assign value
        Fruit fruit = fruitList.get(position);

        holder.txtName.setText(fruit.getName());
        holder.txtDescription.setText(fruit.getDescription());
        holder.imgFruit.setImageResource(fruit.getImage());

        return convertView;
    }
}
