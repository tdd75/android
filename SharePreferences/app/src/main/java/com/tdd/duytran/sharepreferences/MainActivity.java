package com.tdd.duytran.sharepreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtUsername, edtPassword;
    CheckBox cbRemember;
    Button btnConfirm;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();
        sharedPreferences = getSharedPreferences("dataLogin", MODE_PRIVATE);
        edtUsername.setText(sharedPreferences.getString("username", ""));
        edtPassword.setText(sharedPreferences.getString("password", ""));
        cbRemember.setChecked(sharedPreferences.getBoolean("checked", false));

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                if (username.equals("admin") && password.equals("123456")) {
                    Toast.makeText(MainActivity.this, "Login completed", Toast.LENGTH_SHORT).show();
                    if (cbRemember.isChecked()) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username", username);
                        editor.putString("password", password);
                        editor.putBoolean("checked", true);
                        editor.commit();
                    } else {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("username");
                        editor.remove("password");
                        editor.remove("checked");
                        editor.commit();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void mapping() {
        edtUsername = (EditText) findViewById(R.id.editTextusername);
        edtPassword = (EditText) findViewById(R.id.editTextPassword);
        cbRemember = (CheckBox) findViewById(R.id.checkBoxRemember);
        btnConfirm = (Button) findViewById(R.id.buttonConfirm);
    }
}