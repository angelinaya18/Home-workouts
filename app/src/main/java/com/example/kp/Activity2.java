package com.example.kp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }

    public void onClick2(View v){
        switch(v.getId()){
            case R.id.button11: {
                Intent intent=new Intent(this,MainActivity.class); //Я
                startActivity(intent);
                break;}
            case R.id.button10: {
                Intent intent2=new Intent(this,Activity5.class); //питание
                startActivity(intent2);
                break;}
            case R.id.vt: {
                Intent intent3=new Intent(this,Activity3.class); //На все тело
                startActivity(intent3);
                break;}

            case R.id.press: {
                Intent intent4=new Intent(this,Activity6.class); //Пресс
                startActivity(intent4);
                break;}
            case R.id.sost: {
                Intent intent5=new Intent(this,Activity4.class); //Составить самому
                startActivity(intent5);
                break;}
            case R.id.yag: {
                Intent intent6=new Intent(this,Activity7.class); //Ягодицы
                startActivity(intent6);
                break;}
            case R.id.rok: {
                Intent intent7=new Intent(this,Activity8.class); //Руки
                startActivity(intent7);
                break;}
            default:break;
        }
    }
}
