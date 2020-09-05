package com.tdd.duytran.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvName;
    ArrayList<String> arrayName;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvName = (ListView) findViewById(R.id.listViewName);
        arrayName = new ArrayList<>();
        addArrayName();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayName);

        lvName.setAdapter(adapter);
        lvName.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                confirmDelete(i);
                return false;
            }
        });
    }

    private void confirmDelete(final int position) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Notification!");
        alertDialog.setIcon(R.drawable.exclamation_icon);

        alertDialog.setMessage("Do you want to delete " + arrayName.get(position) +"?");

        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                arrayName.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        alertDialog.show();
    }

    private void addArrayName() {
        arrayName.add("Java");
        arrayName.add("Kotlin");
        arrayName.add("Objective-C");
        arrayName.add("Swift");
        arrayName.add("ReactNative");
        arrayName.add("Flutter");
    }
}