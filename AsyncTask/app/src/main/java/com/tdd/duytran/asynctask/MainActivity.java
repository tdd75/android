package com.tdd.duytran.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText edtUrl;
    Button btnLoadImage;
    ImageView imgPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();

        edtUrl.setText("https://cellphones.com.vn/sforum/wp-content/uploads/2020/02/nhuoc-diem-che-do-may-bay-1.jpg");

        btnLoadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new LoadImage().execute(edtUrl.getText().toString());
            }
        });
    }

    private void mapping() {
        btnLoadImage = (Button) findViewById(R.id.buttonLoadImage);
        imgPicture = (ImageView) findViewById(R.id.imageViewPicture);
        edtUrl = (EditText) findViewById(R.id.editTextUrlImage);
    }

    private class LoadImage extends AsyncTask<String, Void, Bitmap> {
        Bitmap bitmap = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                InputStream inputStream = url.openConnection().getInputStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imgPicture.setImageBitmap(bitmap);
        }
    }
}