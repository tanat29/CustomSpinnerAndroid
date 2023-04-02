package com.example.customspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<AlgorithmItem> algorithmItems;
    AlgorithmAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initList();

        Spinner spinner = findViewById(R.id.spinner_algorithm);
        adapter = new AlgorithmAdapter(this, algorithmItems);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent,
                                               View view, int position, long id) {

                        AlgorithmItem clickedItem = (AlgorithmItem)
                                parent.getItemAtPosition(position);
                        String name = clickedItem.getAlgorithmName();
                        Toast.makeText(MainActivity.this, name + " selected", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
    }

    private void initList() {
        algorithmItems = new ArrayList<>();
        algorithmItems.add(new AlgorithmItem("Quick Sort", "ic_data1"));
        algorithmItems.add(new AlgorithmItem("Merge Sort", "ic_shop"));
        algorithmItems.add(new AlgorithmItem("Heap Sort", "ic_data1"));
        algorithmItems.add(new AlgorithmItem("Prims Algorithm", "ic_notification"));
        algorithmItems.add(new AlgorithmItem("Kruskal Algorithm", "ic_data1"));
        algorithmItems.add(new AlgorithmItem("Rabin Karp", "ic_notification"));
        algorithmItems.add(new AlgorithmItem("Binary Search", "ic_shop"));
    }
}