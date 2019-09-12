package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.nio.charset.Charset;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClicked(View v) {
        TextView textBar = findViewById(R.id.textBar);

        if (v.getId() == R.id._0)
            textBar.append("0");
        if (v.getId() == R.id._1)
            textBar.append("1");
        if (v.getId() == R.id._2)
            textBar.append("2");
        if (v.getId() == R.id._3)
            textBar.append("3");
        if (v.getId() == R.id._4)
            textBar.append("4");
        if (v.getId() == R.id._5)
            textBar.append("5");
        if (v.getId() == R.id._6)
            textBar.append("6");
        if (v.getId() == R.id._7)
            textBar.append("7");
        if (v.getId() == R.id._8)
            textBar.append("8");
        if (v.getId() == R.id._9)
            textBar.append("9");

        if (v.getId() == R.id.plus)
            textBar.append("+");
        if (v.getId() == R.id.minus)
            textBar.append("-");
        if (v.getId() == R.id.times)
            textBar.append("*");
        if (v.getId() == R.id.divided_by)
            textBar.append("/");
        if (v.getId() == R.id.point)
            textBar.append(".");
    }

    public void onClearClicked(View v) {
        TextView textBar = findViewById(R.id.textBar);
        textBar.setText("");
    }

    public void onBackClicked(View v) {
        TextView textBar = findViewById(R.id.textBar);
        String currentText = textBar.getText().toString();

        if (currentText.length() > 0) {
            String newText = currentText.substring(0, currentText.length() - 1);
            textBar.setText(newText);
        }
    }

    public void onEqualsClicked(View v) {
        TextView textBar = findViewById(R.id.textBar);
        String currentText = textBar.getText().toString();

        if (currentText.length() > 2) {
            String num1 = currentText.substring(0, 1);
            String operand = currentText.substring(1, 2);
            String num2 = currentText.substring(2, 3);

            int int1 = Integer.parseInt(num1);
            int int2 = Integer.parseInt(num2);
            int result = 0;

            if (operand.equals("+"))
                result = int1 + int2;
            if(operand.equals("-"))
                result = int1 - int2;
            if(operand.equals("*"))
                result = int1 * int2;
            if(operand.equals("/"))
                result = int1 / int2;

            String textResult = Integer.toString(result);
            textBar.setText(textResult);
        }
    }
}