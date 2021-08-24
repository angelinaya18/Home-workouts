package com.example.kp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Activity3 extends AppCompatActivity {

    ListView listTren;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        listTren = findViewById(R.id.listTren2);
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner10);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {

                String[] choose = getResources().getStringArray(R.array.num_tren);

                // определяем строковый массив
                String[] tr_body=getResources().getStringArray(R.array.body1);
                switch (choose[selectedItemPosition]){
                    case "1":tr_body = getResources().getStringArray(R.array.body1);break;
                    case "2":tr_body = getResources().getStringArray(R.array.body2);break;
                    case "3":tr_body = getResources().getStringArray(R.array.body3);break;
                    case "4":tr_body = getResources().getStringArray(R.array.body4);break;
                    case "5":tr_body = getResources().getStringArray(R.array.body5);break;
                    case "6":tr_body = getResources().getStringArray(R.array.body6);break;
                }
                // используем адаптер данных
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(Activity3.this, android.R.layout.simple_list_item_checked,tr_body);
                listTren.setAdapter(adapter);
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
