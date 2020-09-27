package com.tdd.duytran.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gvPicture;
    ArrayList<Picture> arrayPicture;
    PictureAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();
        adapter = new PictureAdapter(MainActivity.this, R.layout.line_picture, arrayPicture);
        gvPicture.setAdapter(adapter);

        gvPicture.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, arrayPicture.get(position).getName().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void mapping() {
        gvPicture = (GridView) findViewById(R.id.gridViewPicture);
        arrayPicture = new ArrayList<>();
        arrayPicture.add(new Picture("Bình minh", R.drawable.binh_minh));
        arrayPicture.add(new Picture("Bình minh tuyết", R.drawable.binh_minh_tuyet));
        arrayPicture.add(new Picture("Bình minh xa", R.drawable.binh_minh_xa));
        arrayPicture.add(new Picture("Bướm và hoa", R.drawable.buom_va_hoa));
        arrayPicture.add(new Picture("Cây cầu", R.drawable.cay_cau));
        arrayPicture.add(new Picture("Cây cổ thụ", R.drawable.cay_co_thu));
        arrayPicture.add(new Picture("Cây cổ thụ và bình minh", R.drawable.cay_co_thu_va_binh_minh));
        arrayPicture.add(new Picture("Cỏ", R.drawable.co));
        arrayPicture.add(new Picture("Cỏ hình tròn", R.drawable.co_hinh_tron));
        arrayPicture.add(new Picture("Cỏ và bình minh", R.drawable.co_va_binh_minh));
        arrayPicture.add(new Picture("Cối xay gió", R.drawable.coi_xay_gio));
        arrayPicture.add(new Picture("Con đường mơ ước", R.drawable.con_duong_mo_uoc));
    }
}