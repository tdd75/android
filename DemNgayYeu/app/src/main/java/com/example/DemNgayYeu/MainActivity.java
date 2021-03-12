package com.example.DemNgayYeu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    Database database;
    TextView txtFrom, txtCount;
    SimpleDateFormat simpleDateFormat;
    int _day, _month, _year;
    Calendar _calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();
        database.queryData("CREATE TABLE IF NOT EXISTS Date(Id INTEGER PRIMARY KEY AUTOINCREMENT, Day INTEGER, Month INTEGER, Year INTEGER)");
        getDataDate();

        txtFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickDate();
            }
        });
        updateCounter();
    }

    private void getDataDate() {
        Cursor dataDate = database.getData("SELECT * FROM Date ORDER BY Id DESC");
        if (dataDate.moveToNext()) {
            _day = dataDate.getInt(1);
            _month = dataDate.getInt(2);
            _year = dataDate.getInt(3);
        } else {
            Calendar calendar = Calendar.getInstance();
            _day = calendar.get(Calendar.DATE);
            _month = calendar.get(Calendar.MONTH);
            _year = calendar.get(Calendar.YEAR);
        }
        _calendar.set(_year, _month, _day);
        txtFrom.setText(simpleDateFormat.format(_calendar.getTime()));
    }

    private void pickDate() {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, (view, yearPicked, monthPicked, dayPicked) -> {
            calendar.set(yearPicked, monthPicked, dayPicked);
            txtFrom.setText(simpleDateFormat.format(calendar.getTime()));
            database.queryData("INSERT INTO Date VALUES(null, " + dayPicked + ", " + monthPicked + ", " + yearPicked + ")");
            _year = yearPicked;
            _month = monthPicked;
            _day = dayPicked;
            _calendar.set(_year, _month, _day);
        }, _year, _month, _day);
        // month + 1
        datePickerDialog.show();
    }

    private void updateCounter() {
        CountDownTimer countDownTimer = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Calendar calendar = Calendar.getInstance();
                txtCount.setText("");
                int day = calendar.get(Calendar.DATE);
                double second = (calendar.getTimeInMillis() - _calendar.getTimeInMillis()) / 1000;
                if (second <= 0)
                    txtCount.setText("Chưa iu được ngày nào :v");
                else {
                    int countDay = (int) (second/86400);
                    txtCount.append((int) countDay + " ngày " + calendar.get(Calendar.HOUR_OF_DAY) + " giờ " + calendar.get(Calendar.MINUTE) + " phút " + calendar.get(Calendar.SECOND) + " giây ");
                }
            }

            @Override
            public void onFinish() {
                this.start();
            }
        };
        countDownTimer.start();
    }

    private void mapping() {
        database = new Database(this, "date.sqlite", null, 1);
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        txtFrom = (TextView) findViewById(R.id.textViewFrom);
        txtCount = (TextView) findViewById(R.id.textViewCount);
        _calendar = Calendar.getInstance();
    }

}