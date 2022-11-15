package com.example.homework_app;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText a;
    EditText b;
    EditText c;
    TextView textX;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        c = findViewById(R.id.c);
        textX = findViewById(R.id.x);
    }
    public int toInt(EditText editText){
        if (editText.getText().toString().isEmpty()){
            Toast.makeText(this,"Ты зыбыл ввести число", Toast.LENGTH_SHORT).show();
            return 0;
        }
        return Integer.parseInt(editText.getText().toString());
    }
    public int isZero(EditText editText){
        if (editText.getText().toString() == "0"){
            Toast.makeText(this,"а = 0, выбери другое число", Toast.LENGTH_SHORT).show();
            return 0;
        }
        return Integer.parseInt(editText.getText().toString());
    }
    public void click(View view){
        int a = toInt(this.a);
        int b = toInt(this.b);
        int c = toInt(this.c);
        int discriminant = b*b - 4 * a * c;
        String x1 = String.format("%.2f", (-b + Math.pow(discriminant, 0.5)/(a*2)));
        String x2 = String.format("%.2f", (-b - Math.pow(discriminant, 0.5)/(a*2)));

        if (discriminant>0){
            textX.setText("x1 = " + x1 +"\n" +"x2 = " + x2);
        }
        else if (discriminant==0){
            textX.setText("x = " + x1);
        }
        else if (discriminant<0){
            textX.setText("Решений нет");
        }
    }
}