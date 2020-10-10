package com.tdd.duytran.learnenglish;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static Database database;
    ListView lvWord;
    ArrayList<Word> arrayWord;
    WordAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();

        database = new Database(this, "English.sqlite", null, 1);
        database.queryData("CREATE TABLE IF NOT EXISTS Word(Id INTEGER PRIMARY KEY AUTOINCREMENT, English NVARCHAR(30), Vietnamese NVARCHAR(30), Example NVARCHAR(200), Picture BLOB)");

        Cursor cursor = database.getData("SELECT * FROM Word");
        while (cursor.moveToNext()) {
            arrayWord.add(new Word(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getBlob(4)));
        }

        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_new_word, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        startActivity(new Intent(MainActivity.this, AddNewWordActivity.class));
        return super.onOptionsItemSelected(item);
    }

    private void mapping() {
        lvWord = (ListView) findViewById(R.id.listViewWord);
        arrayWord = new ArrayList<>();
        adapter = new WordAdapter(this, R.layout.line_word, arrayWord);
        lvWord.setAdapter(adapter);
    }
}