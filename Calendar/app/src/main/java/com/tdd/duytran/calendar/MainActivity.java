package com.tdd.duytran.calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView txtTime, txtInterval;
    EditText edtDate1, edtDate2;
    Button btnCalculate;
    ;
    Calendar calendar1, calendar2;
    SimpleDateFormat dateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();

        //Date
        Calendar calendar = Calendar.getInstance();
        txtTime.append(calendar.getTime() + "\n");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        txtTime.append(dateFormat.format(calendar.getTime()) + "\n");
        SimpleDateFormat hourFormat = new SimpleDateFormat("hh:mm:ss a");
        txtTime.append(hourFormat.format(calendar.getTime()) + "\n");

        // Date Picker Dialog
        edtDate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickDate1();
            }
        });
        edtDate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickDate2();
            }
        });
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateInterval();
            }
        });
    }

    private void mapping() {
        txtTime = (TextView) findViewById(R.id.textViewTime);
        txtInterval = (TextView) findViewById(R.id.textViewInterval);
        edtDate1 = (EditText) findViewById(R.id.editTextDate1);
        edtDate2 = (EditText) findViewById(R.id.editTextDate2);
        btnCalculate = (Button) findViewById(R.id.buttonCalculate);
    }

    private void pickDate1() {
        calendar1 = Calendar.getInstance();
        int day = calendar1.get(Calendar.DATE);
        int month = calendar1.get(Calendar.MONTH);
        int year = calendar1.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar1.set(year, month, dayOfMonth);
                dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                edtDate1.setText(dateFormat.format(calendar1.getTime()));
            }
        }, year, month, day);
        // month + 1
        datePickerDialog.show();
    }

    private void pickDate2() {
        calendar2 = Calendar.getInstance();
        int day = calendar2.get(Calendar.DATE);
        int month = calendar2.get(Calendar.MONTH);
        int year = calendar2.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar2.set(year, month, dayOfMonth);
                dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                edtDate2.setText(dateFormat.format(calendar2.getTime()));
            }
        }, year, month, day);
        datePickerDialog.show();
    }

    private void calculateInterval() {
        int countDay = (int) ((calendar2.getTimeInMillis() - calendar1.getTimeInMillis()) / (1000 * 60 * 60 * 24));
        if (countDay < 0) {
            Toast.makeText(this, "Please enter Date 2 after Date 1", Toast.LENGTH_SHORT).show();
        } else {
            txtInterval.setText("Interval: " + countDay);
        }
    }
}