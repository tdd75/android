package com.tdd.duytran.calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView txtTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTime = (TextView) findViewById(R.id.textViewTime);

        Calendar calendar = Calendar.getInstance();
        txtTime.append(calendar.getTime() + "\n");

        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        txtTime.append(formatDate.format(calendar.getTime()) + "\n");
        SimpleDateFormat formatHour = new SimpleDateFormat("hh:mm:ss a");
        txtTime.append(formatHour.format(calendar.getTime()) + "\n");
    }
}