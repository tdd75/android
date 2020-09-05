package com.tdd.duytran.popupmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMenu = (Button) findViewById(R.id.buttonMenu);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMenu();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_popup, menu);
        return super.onCreateOptionsMenu(menu);
    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.menuSearch:
//            case R.id.menuShare:
//            case R.id.menuSetting:
//            case R.id.menuName:
//            case R.id.menuPhoneNumber:
//                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.menuExit:
//                System.exit(0);
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    private void showMenu() {
        PopupMenu popupMenu = new PopupMenu(this, btnMenu);
        popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menuSearch:
                    case R.id.menuShare:
                    case R.id.menuSetting:
                    case R.id.menuName:
                    case R.id.menuPhoneNumber:
                        Toast.makeText(MainActivity.this, menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menuExit:
                        System.exit(0);
                        break;
                    default:
                        return false;
                }
                return true;
            }
        });
    }

}