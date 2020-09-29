package com.tdd.duytran.intentexplicit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    Button btnMain, btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMain = (Button) findViewById(R.id.buttonMain);
        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        Log.d("OUT", "onCreate Main");

        // send data
        btnSend = (Button) findViewById(R.id.buttonSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//                intent.putExtra("data", 2020);

//                Student student = new Student("Duy", 20);
//                intent.putExtra("data", (Serializable) student);

                Bundle bundle = new Bundle();
                bundle.putInt("number", 75);
                bundle.putString("string", "This is a string");
                Student student = new Student("Duy", 20);
                bundle.putSerializable("student", student);
                intent.putExtra("data", bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("OUT", "onPause Main");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("OUT", "onRestart Main");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("OUT", "onStart Main");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("OUT", "onResume Main");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("OUT", "onStop Main");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("OUT", "onDestroy Main");
    }

}