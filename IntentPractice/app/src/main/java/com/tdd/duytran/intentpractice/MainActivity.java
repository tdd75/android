package com.tdd.duytran.intentpractice;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<String> arrayName;
    ImageView imgRoot, imgAnswer;
    TextView txtPoint;
    int REQUEST_CODE_PICTURE = 1234, idRoot, point = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();

        txtPoint.setText(point + "");

        arrayName = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.list_name)));
        newGame();
        imgAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PictureActivity.class);
                startActivityForResult(intent, REQUEST_CODE_PICTURE);
            }
        });

    }

    private void mapping() {
        imgRoot = (ImageView) findViewById(R.id.imageViewRoot);
        imgAnswer = (ImageView) findViewById(R.id.imageViewAnswer);
        txtPoint = (TextView) findViewById(R.id.textViewPoint);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE_PICTURE && resultCode == RESULT_OK && data != null) {
            int idAnswer = getResources().getIdentifier(data.getStringExtra("answer"), "drawable", getPackageName());
            imgAnswer.setImageResource(idAnswer);
            if(idAnswer == idRoot) {
                Toast.makeText(this, "Correct !!!", Toast.LENGTH_SHORT).show();
                point += 10;
                new CountDownTimer(2000, 100) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                    }
                    @Override
                    public void onFinish() {
                        newGame();
                    }
                }.start();
            } else {
                Toast.makeText(this, "Wrong ...", Toast.LENGTH_SHORT).show();
                point -= 5;
            }
        }

        if(requestCode == REQUEST_CODE_PICTURE && resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "You've not selected a picture.\nDo you want to see it again? =]] ", Toast.LENGTH_LONG).show();
            point -= 15;
        }

        txtPoint.setText(point + "");
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void newGame() {
        Collections.shuffle(arrayName);
        idRoot = getResources().getIdentifier(arrayName.get(7), "drawable", getPackageName());
        imgRoot.setImageResource(idRoot);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.reload, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        newGame();
        return super.onOptionsItemSelected(item);
    }
}