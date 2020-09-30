package com.tdd.duytran.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvFruit;
    ArrayList<Fruit> arrayFruit;
    FruitAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();

        adapter = new FruitAdapter(MainActivity.this, R.layout.line_fruit, arrayFruit);
        lvFruit.setAdapter(adapter);

    }

    private void mapping() {
        lvFruit = (ListView) findViewById(R.id.listViewFruit);
        arrayFruit = new ArrayList<>();
        arrayFruit.add(new Fruit("Orange", "Quả cam", R.drawable.orange));
        arrayFruit.add(new Fruit("Apple", "Quả táo", R.drawable.apple));
        arrayFruit.add(new Fruit("Pineapple", "Quả dứa", R.drawable.pineapple));
        arrayFruit.add(new Fruit("Strawberry", "Quả dâu tây", R.drawable.strawberry));
        arrayFruit.add(new Fruit("Banana", "Quả chuối", R.drawable.banana));
        arrayFruit.add(new Fruit("Grape", "Quả nho", R.drawable.grape));
        arrayFruit.add(new Fruit("Watermelon", "Quả dưa hấu", R.drawable.watermelon));
        arrayFruit.add(new Fruit("Lemon", "Quả chanh", R.drawable.lemon));

        arrayFruit.add(new Fruit("Orange", "Quả cam", R.drawable.orange));
        arrayFruit.add(new Fruit("Apple", "Quả táo", R.drawable.apple));
        arrayFruit.add(new Fruit("Pineapple", "Quả dứa", R.drawable.pineapple));
        arrayFruit.add(new Fruit("Strawberry", "Quả dâu tây", R.drawable.strawberry));
        arrayFruit.add(new Fruit("Banana", "Quả chuối", R.drawable.banana));
        arrayFruit.add(new Fruit("Grape", "Quả nho", R.drawable.grape));
        arrayFruit.add(new Fruit("Watermelon", "Quả dưa hấu", R.drawable.watermelon));
        arrayFruit.add(new Fruit("Lemon", "Quả chanh", R.drawable.lemon));

        arrayFruit.add(new Fruit("Orange", "Quả cam", R.drawable.orange));
        arrayFruit.add(new Fruit("Apple", "Quả táo", R.drawable.apple));
        arrayFruit.add(new Fruit("Pineapple", "Quả dứa", R.drawable.pineapple));
        arrayFruit.add(new Fruit("Strawberry", "Quả dâu tây", R.drawable.strawberry));
        arrayFruit.add(new Fruit("Banana", "Quả chuối", R.drawable.banana));
        arrayFruit.add(new Fruit("Grape", "Quả nho", R.drawable.grape));
        arrayFruit.add(new Fruit("Watermelon", "Quả dưa hấu", R.drawable.watermelon));
        arrayFruit.add(new Fruit("Lemon", "Quả chanh", R.drawable.lemon));

    }
}