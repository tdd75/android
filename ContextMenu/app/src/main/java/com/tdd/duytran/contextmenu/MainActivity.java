package com.tdd.duytran.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnColor;
    ConstraintLayout display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnColor = (Button) findViewById(R.id.buttonColor);
        display = (ConstraintLayout) findViewById(R.id.display);
        registerForContextMenu(btnColor);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuSearch:
            case R.id.menuEmail:
            case R.id.menuPhone:
            case R.id.menuCompany:
            case R.id.menuShare:
            case R.id.menuSetting:
                Toast.makeText(this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context, menu);
        menu.setHeaderTitle("Choose Color");
        menu.setHeaderIcon(R.mipmap.ic_launcher);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.colorRed:
                display.setBackgroundColor(Color.RED);
                break;
            case R.id.colorYellow:
                display.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.colorGreen:
                display.setBackgroundColor(Color.GREEN);
                break;
        }
        return super.onContextItemSelected(item);
    }
}