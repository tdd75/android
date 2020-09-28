package com.tdd.duytran.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtLogin = (TextView) findViewById(R.id.textViewLogin);
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogLogin();
            }
        });
    }

    private void dialogLogin() {
        final Dialog dialog = new Dialog(this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

        final EditText edtUsername = (EditText) dialog.findViewById(R.id.textViewUsername);
        final EditText edtPassword = (EditText) dialog.findViewById(R.id.textViewPassword);
        final Button btnConfirm = (Button) dialog.findViewById(R.id.buttonConfirm);
        final Button btnCancel = (Button) dialog.findViewById(R.id.buttonCancel);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                if (username.equals("admin") && password.equals("123456")) {
                    Toast.makeText(MainActivity.this, "Login completed !", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                } else {
                    Toast.makeText(MainActivity.this, "Login failed !", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                        dialog.cancel();
                dialog.dismiss();
            }
        });
    }
}