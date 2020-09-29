package com.tdd.duytran.intentimplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtLink;
    Button btnSend, btnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();

        txtLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.google.com/"));
                startActivity(intent);
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SENDTO);
                intent.putExtra("sms_body", "Hello !");
                intent.setData(Uri.parse("sms:0123432452"));    // send sms to 0123432452
                // sms_body and sms: is default
                startActivity(intent);
            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);       // api level < 23 can use ACTION_CALL
                intent.setData(Uri.parse("tel:0123242345"));
                startActivity(intent);
            }
        });
    }
    private void mapping() {
        txtLink = (TextView) findViewById(R.id.textViewLink);
        btnSend = (Button) findViewById(R.id.buttonSend);
        btnCall = (Button) findViewById(R.id.buttonCall);
    }
}