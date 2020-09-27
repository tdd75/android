package com.tdd.duytran.drawableclip;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imgPicture;
    Button btnClip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();

        imgPicture.setImageLevel(1000);

        final ClipDrawable clipDrawable = (ClipDrawable) imgPicture.getDrawable();

        btnClip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (clipDrawable.getLevel() < 10000) {
                            imgPicture.setImageLevel(clipDrawable.getLevel() + 1000);
                        } else {
                            imgPicture.setImageLevel(0);
                        }
                        handler.postDelayed(this, 15);
                    }
                }, 0);
            }
        });

    }

    private void mapping() {
        imgPicture = (ImageView) findViewById(R.id.imageViewPicture);
        btnClip = (Button) findViewById(R.id.buttonClip);
    }
}