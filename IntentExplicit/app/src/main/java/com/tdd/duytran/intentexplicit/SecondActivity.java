package com.tdd.duytran.intentexplicit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends Activity {

    Button btnSecond;
    TextView txtResult;

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
                overridePendingTransition(R.anim.anim_enter, R.anim.anim_exit);
            }
        });
        Log.d("OUT", "onCreate Second");

        // get data
        txtResult = (TextView) findViewById(R.id.textViewResult);
        Intent intent = getIntent();
//        txtResult.setText(intent.getIntExtra("data", 1234) + "");

//        Student student = (Student) intent.getSerializableExtra("data");
//        txtResult.setText(student.getName() + "");
        Bundle bundle = intent.getBundleExtra("data");
        if(bundle != null) {
            Student student = (Student) bundle.getSerializable("student");
            txtResult.setText(student.getName());
            txtResult.setText(bundle.getInt("number") + "");
        }
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