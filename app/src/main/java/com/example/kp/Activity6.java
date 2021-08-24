package com.example.kp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class Activity6 extends AppCompatActivity {

    ListView listTren;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);
        listTren = findViewById(R.id.listTren2);
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner10);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {

                String[] choose = getResources().getStringArray(R.array.num_tren);

                // определяем строковый массив
                String[] tr_press=getResources().getStringArray(R.array.press1);
                switch (choose[selectedItemPosition]){
                    case "1":tr_press = getResources().getStringArray(R.array.press1);break;
                    case "2":tr_press = getResources().getStringArray(R.array.press2);break;
                    case "3":tr_press = getResources().getStringArray(R.array.press3);break;
                    case "4":tr_press = getResources().getStringArray(R.array.press4);break;
                    case "5":tr_press = getResources().getStringArray(R.array.press5);break;
                    case "6":tr_press = getResources().getStringArray(R.array.press6);break;
                }
                // используем адаптер данных
                ArrayAdapter<String> adapter = new ArrayAdapter<>(Activity6.this, android.R.layout.simple_list_item_checked,tr_press);
                listTren.setAdapter(adapter);
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }
}
