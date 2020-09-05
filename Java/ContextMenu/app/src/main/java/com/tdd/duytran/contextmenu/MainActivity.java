package com.tdd.duytran.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

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
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        getMenuInflater().inflate(R.menu.menu_context, menu);
        menu.setHeaderTitle("Choose Color");
        menu.setHeaderIcon(R.drawable.color_icon);
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