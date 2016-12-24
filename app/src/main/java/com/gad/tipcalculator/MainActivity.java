package com.gad.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Calculator calc = new Calculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnClr).setOnClickListener(this);
        findViewById(R.id.btnDel).setOnClickListener(this);
        findViewById(R.id.btnPoint).setOnClickListener(this);
        findViewById(R.id.btnNum1).setOnClickListener(this);
        findViewById(R.id.btnNum2).setOnClickListener(this);
        findViewById(R.id.btnNum3).setOnClickListener(this);
        findViewById(R.id.btnNum4).setOnClickListener(this);
        findViewById(R.id.btnNum5).setOnClickListener(this);
        findViewById(R.id.btnNum6).setOnClickListener(this);
        findViewById(R.id.btnNum7).setOnClickListener(this);
        findViewById(R.id.btnNum8).setOnClickListener(this);
        findViewById(R.id.btnNum9).setOnClickListener(this);
        findViewById(R.id.btnNum0).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        TextView textView = (TextView)findViewById(R.id.totalAmt);
        String total = textView.getText().toString();

        if (v.getId() == R.id.btnClr) {
            total = "0";
        } else if (v.getId() == R.id.btnDel) {
            total = total.substring(0, total.length() - 2);
        } else if (v.getId() == R.id.btnPoint) {
            total = total.concat(".");
        } else if (v.getId() == R.id.btnNum0) {
            total = total.concat("0");
        } else if (v.getId() == R.id.btnNum1) {
            total = total.concat("1");
        } else if (v.getId() == R.id.btnNum2) {
            total = total.concat("2");
        } else if (v.getId() == R.id.btnNum3) {
            total = total.concat("3");
        } else if (v.getId() == R.id.btnNum4) {
            total = total.concat("4");
        } else if (v.getId() == R.id.btnNum5) {
            total = total.concat("5");
        } else if (v.getId() == R.id.btnNum6) {
            total = total.concat("6");
        } else if (v.getId() == R.id.btnNum7) {
            total = total.concat("7");
        } else if (v.getId() == R.id.btnNum8) {
            total = total.concat("8");
        } else if (v.getId() == R.id.btnNum9) {
            total = total.concat("9");
        }

        //recalculate after each button press
        try {
            Calculator.Result r = calc.calc(Float.parseFloat(total));
            textView.setText(total);
            setField(R.id.tip15, r.getTip15());
            setField(R.id.tip18, r.getTip18());
            setField(R.id.tip20, r.getTip20());
            setField(R.id.total15, r.getTot15());
            setField(R.id.total18, r.getTot18());
            setField(R.id.total20, r.getTot20());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setField(int id, float amt) {
        TextView field = (TextView) findViewById(id);
        field.setText(String.format("%.2f", amt));
    }

    private void resetField(int id) {
        TextView field = (TextView) findViewById(id);
        field.setText("");
    }
}
