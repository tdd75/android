package com.tdd.duytran.intentdataresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText edtNew;
    Button btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        mapping();

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("newName", edtNew.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    private void mapping() {
        edtNew = (EditText) findViewById(R.id.editTextNew);
        btnConfirm = (Button) findViewById(R.id.buttonConfirm);
    }

}