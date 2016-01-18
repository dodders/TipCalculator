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

        Button btnCalc = (Button) findViewById(R.id.btnCalc);
        Button btnReset = (Button) findViewById(R.id.btnReset);
        btnCalc.setOnClickListener(this);
        btnReset.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCalc) {
            try {
                EditText field = (EditText) findViewById(R.id.totalAmt);
                float total = Float.valueOf(String.valueOf(field.getText()));
                Calculator.Result r = calc.calc(total);
                setField(R.id.tip15, r.getTip15());
                setField(R.id.tip18, r.getTip18());
                setField(R.id.tip20, r.getTip20());
                setField(R.id.total15, r.getTot15());
                setField(R.id.total18, r.getTot18());
                setField(R.id.total20, r.getTot20());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (v.getId() == R.id.btnReset) {
            EditText tot = (EditText) findViewById(R.id.totalAmt);
            tot.setText("");
            resetField(R.id.tip15);
            resetField(R.id.tip18);
            resetField(R.id.tip20);
            resetField(R.id.total15);
            resetField(R.id.total18);
            resetField(R.id.total20);
        } else {

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
