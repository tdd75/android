package com.tdd.duytran.intentpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.Collection;
import java.util.Collections;

public class PictureActivity extends Activity {

    TableLayout tablePicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);

        tablePicture = findViewById(R.id.tableLayoutPicture);

        int numRow = 3, numColumn = 3;

        Collections.shuffle(MainActivity.arrayName);

        for (int i = 0; i < numRow; i++) {
            TableRow tableRow = new TableRow(this);
            for (int j = 0; j < numColumn; j++) {
                ImageView imageView = new ImageView(this);

                Resources r = getResources();
                int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, r.getDisplayMetrics());

                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(px, px);
                imageView.setLayoutParams(layoutParams);
                final int position = numRow * i + j;
                int idPicture = getResources().getIdentifier(MainActivity.arrayName.get(position), "drawable", getPackageName());
                imageView.setImageResource(idPicture);
                tableRow.addView(imageView);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.putExtra("answer", MainActivity.arrayName.get(position));
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                });
            }
            tablePicture.addView(tableRow);
        }

    }
}