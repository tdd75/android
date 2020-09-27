package com.tdd.duytran.globalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtName, edtEmail, edtPhone;
    Button btnSubmit;
    TextView txtInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String email = edtEmail.getText().toString();
                String phone = edtPhone.getText().toString();
                String txtHello = getResources().getString(R.string.text_hello);
                String txtEmail = getResources().getString(R.string.text_email);
                String txtPhone = getResources().getString(R.string.text_phone);
                txtInfo.setText(txtHello + " " + name + " !\n" + txtEmail + ": " + email + "\n" + txtPhone + ": " + phone);
            }
        });
    }
    private void mapping() {
        edtName = (EditText) findViewById(R.id.editTextName);
        edtEmail = (EditText) findViewById(R.id.editTextEmail);
        edtPhone = (EditText) findViewById(R.id.editTextPhone);
        btnSubmit = (Button) findViewById(R.id.buttonSubmit);
        txtInfo = (TextView) findViewById(R.id.textViewInfo);
    }
}