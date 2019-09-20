package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    BigDecimal number1;
    BigDecimal number2;
    BigDecimal currentNumber;
    boolean clearScreen;
    boolean opClicked = false;
    String operand;

    public void onNumberButtonClicked(View v) {
        TextView textBar = findViewById(R.id.textBar);

        //numbers
        if (v.getId() == R.id._0) {
            if(clearScreen){
                textBar.setText("0");
                clearScreen = false;
            }
            else textBar.append("0");
        }
        if (v.getId() == R.id._1) {
            if(clearScreen){
                textBar.setText("1");
                clearScreen = false;
            }
            else textBar.append("1");
        }
        if (v.getId() == R.id._2) {
            if(clearScreen){
                textBar.setText("2");
                clearScreen = false;
            }
            else textBar.append("2");
        }
        if (v.getId() == R.id._3) {
            if(clearScreen){
                textBar.setText("3");
                clearScreen = false;
            }
            else textBar.append("3");
        }
        if (v.getId() == R.id._4) {
            if(clearScreen){
                textBar.setText("4");
                clearScreen = false;
            }
            else textBar.append("4");
        }
        if (v.getId() == R.id._5) {
            if(clearScreen){
                textBar.setText("5");
                clearScreen = false;
            }
            else textBar.append("5");
        }
        if (v.getId() == R.id._6) {
            if(clearScreen){
                textBar.setText("6");
                clearScreen = false;
            }
            else textBar.append("6");
        }
        if (v.getId() == R.id._7) {
            if(clearScreen){
                textBar.setText("7");
                clearScreen = false;
            }
            else textBar.append("7");
        }
        if (v.getId() == R.id._8) {
            if(clearScreen){
                textBar.setText("8");
                clearScreen = false;
            }
            else textBar.append("8");
        }
        if (v.getId() == R.id._9) {
            if(clearScreen){
                textBar.setText("9");
                clearScreen = false;
            }
            else textBar.append("9");
        }
        if (v.getId() == R.id.point) {
            if(!textBar.getText().toString().contains(".") && !textBar.getText().toString().isEmpty()) {
                textBar.append(".");
            }
        }
    }

    public void onOpButtonClicked(View v){
        TextView textBar = findViewById(R.id.textBar);

        if (v.getId() == R.id.plus) {
            currentNumber = new BigDecimal(textBar.getText().toString());
            if(opClicked){
                if(operand.equals("+"))
                    number1 = number1.add(currentNumber);
                if(operand.equals("-"))
                    number1 = number1.subtract(currentNumber);
                if(operand.equals("*"))
                    number1 = number1.multiply(currentNumber);
                if(operand.equals("/"))
                    number1 = number1.divide(currentNumber);
                operand = "+";
                clearScreen = true;
                return;
            }
            else {
                number1 = currentNumber;
                operand = "+";
                clearScreen = true;
                opClicked = true;
            }
        }
        if (v.getId() == R.id.minus) {
            currentNumber = new BigDecimal(textBar.getText().toString());
            if(opClicked){
                if(operand.equals("+"))
                    number1 = number1.add(currentNumber);
                if(operand.equals("-"))
                    number1 = number1.subtract(currentNumber);
                if(operand.equals("*"))
                    number1 = number1.multiply(currentNumber);
                if(operand.equals("/"))
                    number1 = number1.divide(currentNumber);
                operand = "-";
                clearScreen = true;
                return;
            }
            else {
                number1 = currentNumber;
                operand = "-";
                clearScreen = true;
                opClicked = true;
            }
        }
        if (v.getId() == R.id.times) {
            currentNumber = new BigDecimal(textBar.getText().toString());
            if(opClicked){
                if(operand.equals("+"))
                    number1 = number1.add(currentNumber);
                if(operand.equals("-"))
                    number1 = number1.subtract(currentNumber);
                if(operand.equals("*"))
                    number1 = number1.multiply(currentNumber);
                if(operand.equals("/"))
                    number1 = number1.divide(currentNumber);
                operand = "*";
                clearScreen = true;
                return;
            }
            else {
                number1 = currentNumber;
                operand = "*";
                clearScreen = true;
                opClicked = true;
            }
        }
        if (v.getId() == R.id.divided_by) {
            currentNumber = new BigDecimal(textBar.getText().toString());
            if(opClicked){
                if(operand.equals("+"))
                    number1 = number1.add(currentNumber);
                if(operand.equals("-"))
                    number1 = number1.subtract(currentNumber);
                if(operand.equals("*"))
                    number1 = number1.multiply(currentNumber);
                if(operand.equals("/"))
                    number1 = number1.divide(currentNumber);
                operand = "/";
                clearScreen = true;
                return;
            }
            else {
                number1 = currentNumber;
                operand = "/";
                clearScreen = true;
                opClicked = true;
            }
        }
    }

    public void onClearClicked(View v) {
        TextView textBar = findViewById(R.id.textBar);
        textBar.setText("");
        opClicked = false;
    }

    public void onBackClicked(View v) {
        TextView textBar = findViewById(R.id.textBar);
        String currentText = textBar.getText().toString();

        if (currentText.length() > 0) {
            String newText = currentText.substring(0, currentText.length() - 1);
            textBar.setText(newText);
        }
    }

    public void onNegativeClicked(View v){
        TextView textBar = findViewById(R.id.textBar);
        if(!textBar.getText().toString().isEmpty()){
            float negNum = Float.parseFloat(textBar.getText().toString());
            negNum = negNum * -1;
            textBar.setText(Float.toString(negNum));
        }
    }

    public void onEqualsClicked(View v) {
        TextView textBar = findViewById(R.id.textBar);
        currentNumber = new BigDecimal(textBar.getText().toString());

        if(opClicked) {
            number2 = currentNumber;

            if (operand.equals("+")) {
                BigDecimal result = number1.add(number2);
                if(result.intValue() > 10000000)
                    textBar.setText(result.toString());
                else if(result.floatValue()%1 == 0){
                    long intResult = result.longValue();
                    textBar.setText(Long.toString(intResult));
                }
                else textBar.setText(result.toString());
            }
            if (operand.equals("-")) {
                BigDecimal result = number1.subtract(number2);
                if(result.intValue() > 10000000)
                    textBar.setText(result.toString());
                else if(result.floatValue()%1 == 0){
                    long intResult = result.longValue();
                    textBar.setText(Long.toString(intResult));
                }
                else textBar.setText(result.toString());
            }
            if (operand.equals("*")) {
                BigDecimal result = number1.multiply(number2);
                if(result.intValue() > 10000000) {
                    float floatResult = result.floatValue();
                    textBar.setText(Float.toString(floatResult));
                }
                else if(result.floatValue()%1 == 0){
                    long intResult = result.longValue();
                    textBar.setText(Long.toString(intResult));
                }
                else textBar.setText(result.toString());
            }
            if (operand.equals("/")) {
                BigDecimal result = number1.divide(number2);
                if(result.intValue() > 10000000)
                    textBar.setText(result.toString());
                else if(result.floatValue()%1 == 0){
                    long intResult = result.longValue();
                    textBar.setText(Long.toString(intResult));
                }
                else textBar.setText(result.toString());
            }
            clearScreen = true;
            opClicked = false;
        }
    }
}
