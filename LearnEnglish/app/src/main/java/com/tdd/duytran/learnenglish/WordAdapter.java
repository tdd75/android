package com.tdd.duytran.learnenglish;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class WordAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Word> wordList;

    public WordAdapter(Context context, int layout, List<Word> wordList) {
        this.context = context;
        this.layout = layout;
        this.wordList = wordList;
    }

    @Override
    public int getCount() {
        return wordList.size();
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
        TextView txtEnglish, txtVietnamese, txtExample;
        ImageView imgPicture;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);

            holder.txtEnglish = (TextView) convertView.findViewById(R.id.textViewEnglish);
            holder.txtVietnamese = (TextView) convertView.findViewById(R.id.textViewExample);
            holder.txtExample = (TextView) convertView.findViewById(R.id.textViewExample);
            holder.imgPicture = (ImageView) convertView.findViewById(R.id.imageViewPicture);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Word word = wordList.get(position);

        holder.txtEnglish.setText(word.getEnglish());
        holder.txtVietnamese.setText(word.getVietnamese());
        holder.txtExample.setText(word.getExample());
        // convert byte[] -> bitmap
        byte[] picture = word.getPicture();
        Bitmap bitmap = BitmapFactory.decodeByteArray(picture, 0, picture.length);
        holder.imgPicture.setImageBitmap(bitmap);

        return convertView;
    }
}
