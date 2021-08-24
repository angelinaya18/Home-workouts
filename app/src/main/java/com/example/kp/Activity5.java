package com.example.kp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Activity5 extends AppCompatActivity {

    //Объявим переменные компонентов

    TextView textView;
    Button btnRead;

    //Переменная для работы с БД
    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        mDBHelper = new DatabaseHelper(this);

        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }

        try {
            mDb = mDBHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }

        //Список клиентов
        ArrayList<HashMap<String, Object>> clients = new ArrayList<HashMap<String, Object>>();

        //Список параметров конкретного клиента
        HashMap<String, Object> client;

        //Отправляем запрос в БД
        Cursor cursor = mDb.rawQuery("SELECT * FROM foods", null);
        cursor.moveToFirst();

        //Пробегаем по всем клиентам
        while (!cursor.isAfterLast()) {
            client = new HashMap<String, Object>();

            //Заполняем клиента
            client.put("name",  cursor.getString(1));
            client.put("kbzhu",  cursor.getString(2));

            //Закидываем клиента в список клиентов
            clients.add(client);

            //Переходим к следующему клиенту
            cursor.moveToNext();
        }
        cursor.close();

        //Какие параметры клиента мы будем отображать в соответствующих
        //элементах из разметки adapter_item.xml
        String[] from = { "name", "kbzhu"};
        int[] to = { R.id.textView, R.id.textView2};

        //Создаем адаптер
        SimpleAdapter adapter = new SimpleAdapter(this, clients, R.layout.adapter_item, from, to);
        ListView listView = (ListView) findViewById(R.id.listFoods);
        listView.setAdapter(adapter);
    }


     public void onClick2(View v){
        switch(v.getId()){
            case R.id.button13: {
                Intent intent=new Intent(this,Activity2.class); //тренировки
                startActivity(intent);
                break;}
            case R.id.button15: {
                Intent intent2=new Intent(this,MainActivity.class); //Я
                startActivity(intent2);
                break;}
            case R.id.btnAdd:{
                Intent intent3=new Intent(this,User_Foods_Activity.class); //Я
                startActivity(intent3);
                break;
            }
            default:break;
        }
    }
}
