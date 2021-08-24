package com.example.kp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class Activity7 extends AppCompatActivity {

    ListView listTren;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_7);
        listTren = findViewById(R.id.listTren2);
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner10);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {

                String[] choose = getResources().getStringArray(R.array.num_tren);

                // определяем строковый массив
                String[] tr_yag=getResources().getStringArray(R.array.yag1);
                switch (choose[selectedItemPosition]){
                    case "1":tr_yag = getResources().getStringArray(R.array.yag1);break;
                    case "2":tr_yag = getResources().getStringArray(R.array.yag2);break;
                    case "3":tr_yag = getResources().getStringArray(R.array.yag3);break;
                    case "4":tr_yag = getResources().getStringArray(R.array.yag4);break;
                }
                // используем адаптер данных
                ArrayAdapter<String> adapter = new ArrayAdapter<>(Activity7.this, android.R.layout.simple_list_item_checked,tr_yag);
                listTren.setAdapter(adapter);
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }
}
