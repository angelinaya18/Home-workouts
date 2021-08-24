package com.example.kp;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.EditText;
        import android.widget.Spinner;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    double kA=0;
    double kP=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {

                String[] choose = getResources().getStringArray(R.array.pol);
                switch (choose[selectedItemPosition]){
                    case "Ж":kP=-161;break;
                    case "М":kP=5;break;
                }
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        Spinner spinner2 = (Spinner) findViewById(R.id.spinner7);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {

                String[] choose = getResources().getStringArray(R.array.coeff_activ);
                switch (choose[selectedItemPosition]){
                    case "Физ. нагрузка отсутствует(минимальная)":kA=1.2;break;
                    case "Тренировки ср. тяжести 3 раза в неделю":kA=1.38;break;
                    case "Тренировки ср. тяжести 5 раз в неделю":kA=1.46;break;
                    case "Интенсивные тренировки 5 раз в неделю":kA=1.55;break;
                    case "Тренировки каждый день":kA=1.64;break;
                    case "Интенс. трен. каждый день/2 раза в день":kA=1.73;break;
                    case "Ежедневная физ. нагрузка + физ. работа":kA=1.9;break;
                }
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void onClick(View view){

        EditText ed2=(EditText)findViewById(R.id.editText2); //Вес
        EditText ed3=(EditText)findViewById(R.id.editText3); //Рост
        EditText ed4=(EditText)findViewById(R.id.editText4); //Возраст
        EditText DCI=(EditText)findViewById(R.id.DCI);
        int kbju;
        if ((ed2.getText().toString().matches(""))||(ed3.getText().toString().matches(""))
                ||(ed4.getText().toString().matches(""))||(kP==0)||(kA==0))
        {
            Toast.makeText(MainActivity.this,"Введите все данные",Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            double v=Double.parseDouble(ed2.getText().toString());
            double r=Double.parseDouble(ed3.getText().toString());
            double y=Double.parseDouble(ed4.getText().toString());
            kbju=(int)((v*10+r*6.25-y*5+kP)*kA);
            DCI.setText(kbju+" ккал");
        }
    }

    public void onClick2(View v){
        switch(v.getId()){
            case R.id.button12: {
                Intent intent=new Intent(this,Activity2.class); //тренировки
                startActivity(intent);
                break;}
            case R.id.button16: {
                Intent intent2=new Intent(this,Activity5.class); //питание
                startActivity(intent2);
                break;}
            default:break;
        }
    }
}
