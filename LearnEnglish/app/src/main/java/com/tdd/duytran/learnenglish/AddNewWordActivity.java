package com.tdd.duytran.learnenglish;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AddNewWordActivity extends AppCompatActivity {

    EditText edtEnglish, edtVietnamese, edtExample;
    ImageButton btnCamera;
    Button btnFolder, btnAdd, btnCancel;
    ImageView imgPicture;
    int REQUEST_CODE_CAMERA = 1234;
    int REQUEST_CODE_FOLDER = 5678;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_word);

        mapping();

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, REQUEST_CODE_CAMERA);
            }
        });

        btnFolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_FOLDER);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // convert data ImageView -> byte[]
                BitmapDrawable bitmapDrawable = (BitmapDrawable) imgPicture.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();
                ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArray);
                byte[] picture = byteArray.toByteArray();

                MainActivity.database.InsertWord(
                        edtEnglish.getText().toString().trim(),
                        edtVietnamese.getText().toString().trim(),
                        edtExample.getText().toString().trim(),
                        picture
                );
                Toast.makeText(AddNewWordActivity.this, "Add complete", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AddNewWordActivity.this, MainActivity.class));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE_CAMERA && resultCode == RESULT_OK && data != null) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imgPicture.setImageBitmap(bitmap);
        }
        if(requestCode == REQUEST_CODE_FOLDER && resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imgPicture.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void mapping() {
        edtEnglish = (EditText) findViewById(R.id.editTextEnglish);
        edtVietnamese = (EditText) findViewById(R.id.editTextVietnamese);
        edtExample = (EditText) findViewById(R.id.editTextExample);
        btnCamera = (ImageButton) findViewById(R.id.imageButtonCamera);
        btnFolder = (Button) findViewById(R.id.buttonFolder);
        btnAdd = (Button) findViewById(R.id.buttonAdd);
        btnCancel = (Button) findViewById(R.id.buttonCancel);
        imgPicture = (ImageView) findViewById(R.id.imageViewPicture);
    }
}