package com.tdd.duytran.calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView txtTime;
    EditText edtDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Date
        txtTime = (TextView) findViewById(R.id.textViewTime);

        Calendar calendar = Calendar.getInstance();
        txtTime.append(calendar.getTime() + "\n");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        txtTime.append(dateFormat.format(calendar.getTime()) + "\n");
        SimpleDateFormat hourFormat = new SimpleDateFormat("hh:mm:ss a");
        txtTime.append(hourFormat.format(calendar.getTime()) + "\n");

        // Date Picker Dialog
        edtDate = (EditText) findViewById(R.id.editTextDate);
        edtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickDate();
            }
        });

    }

    private void pickDate() {
        final Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year, month, dayOfMonth);
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                edtDate.setText(dateFormat.format(calendar.getTime()));
            }
        }, year, month, day);
        // month + 1
        datePickerDialog.show();
    }
}