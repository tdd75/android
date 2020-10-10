package com.tdd.duytran.sqlite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Database database;
    ListView lvTask;
    ArrayList<Task> arrayTask;
    TaskAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();
        // create table
        database.queryData("CREATE TABLE IF NOT EXISTS Task(Id INTEGER PRIMARY KEY AUTOINCREMENT, TaskContent VARCHAR(200))");
        getDataTask();
    }

    private void getDataTask() {
        Cursor dataTask = database.getData("SELECT * FROM Task");
        arrayTask.clear();
        while (dataTask.moveToNext()) {
            int id = dataTask.getInt(0);
            String taskContent = dataTask.getString(1);
            arrayTask.add(new Task(id, taskContent));
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_task, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuAdd) {
            showDialogAdd();
        }
        return super.onOptionsItemSelected(item);
    }

    private void showDialogAdd() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_add_task);
        final EditText edtContent = (EditText) dialog.findViewById(R.id.editTextContent);
        Button btnAdd = (Button) dialog.findViewById(R.id.buttonAdd);
        Button btnCancel = (Button) dialog.findViewById(R.id.buttonCancel);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = edtContent.getText().toString();
                database.queryData("INSERT INTO Task VALUES(null, '" + content + "')");
                Toast.makeText(MainActivity.this, "Add complete", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                getDataTask();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void showDialogEdit(final Task task) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_edit_task);
        final EditText edtContent = (EditText) dialog.findViewById(R.id.editTextContent);
        Button btnConfirm = (Button) dialog.findViewById(R.id.buttonConfirm);
        Button btnCancel = (Button) dialog.findViewById(R.id.buttonCancel);

        edtContent.setText(task.getTaskContent());

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newContent = edtContent.getText().toString();
                database.queryData("UPDATE Task SET TaskContent = '" + newContent + "' WHERE Id = '" + task.getId() + "'");
                Toast.makeText(MainActivity.this, "Edit complete", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                getDataTask();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void showDialogDelete(final Task task) {
        final AlertDialog.Builder dialogDelete = new AlertDialog.Builder(this);
        dialogDelete.setMessage("Do you want to delete this task?");
        dialogDelete.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                database.queryData("DELETE FROM Task WHERE Id = '" + task.getId() + "'");
                Toast.makeText(MainActivity.this, "Delete complete", Toast.LENGTH_SHORT).show();
                getDataTask();
            }
        });

        dialogDelete.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        dialogDelete.show();
    }

    private void mapping() {
        // create db
        database = new Database(this, "note.sqlite", null, 1);
        lvTask = (ListView) findViewById(R.id.listViewTask);
        arrayTask = new ArrayList<>();
        adapter = new TaskAdapter(this, R.layout.line_task, arrayTask);
        lvTask.setAdapter(adapter);

    }
}