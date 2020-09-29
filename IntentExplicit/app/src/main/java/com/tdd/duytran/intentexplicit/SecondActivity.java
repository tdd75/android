package com.tdd.duytran.intentexplicit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends Activity {

    Button btnSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnSecond = (Button) findViewById(R.id.buttonSecond);
        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Log.d("OUT", "onCreate Second");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("OUT", "onStart Second");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("OUT", "onRestart Second");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("OUT", "onResume Second");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("OUT", "onPause Second");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("OUT", "onStop Second");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("OUT", "onDestroy Second");
    }
}