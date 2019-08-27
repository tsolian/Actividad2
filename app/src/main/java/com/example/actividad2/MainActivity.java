package com.example.actividad2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton rbDollar, rbEuro;
    EditText etDollar, etEuro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative_layout);
        etDollar = (EditText)findViewById(R.id.etDollars);
        etEuro = (EditText)findViewById(R.id.etEuros);
        rbDollar = (RadioButton)findViewById(R.id.rbDollar);
        rbEuro = (RadioButton)findViewById(R.id.rbEuro);
    }
    public void onRadioButtonClicked(View view) {
        boolean checked = rbDollar.isChecked();
        if (checked){
            etEuro.setText("");
            etDollar.setText("");
            etDollar.setEnabled(true);
            etEuro.setEnabled(false);
            etDollar.requestFocus();
        }else{
            etDollar.setText("");
            etEuro.setText("");
            etDollar.setEnabled(false);
            etEuro.setEnabled(true);
            etEuro.requestFocus();
        }
    }

    public void btConvertFunction (View view) {
        boolean checked = rbDollar.isChecked();
        double dAE = 0.90, eAD = 1.11;
        if (checked) {
            if (etDollar.getText().length() > 0) {
                String etD = etDollar.getText().toString();
                double d = Double.parseDouble(etD);
                if (d > 0) {
                    double resultado = d * dAE;
                    String stringDouble = Double.toString(resultado);
                    etEuro.setText(stringDouble);
                }else{
                    Toast.makeText(this,"Ingrese un monto mayor a cero.",Toast.LENGTH_LONG).show();
                }
            }else{
                Toast.makeText(this,"Ingrese un monto.",Toast.LENGTH_LONG).show();
            }
        } else {
            if (etEuro.getText().length() > 0) {
                String etE = etEuro.getText().toString();
                double e = Double.parseDouble(etE);
                if (e > 0) {
                    double resultado = e * eAD;
                    String stringDouble = Double.toString(resultado);
                    etDollar.setText(stringDouble);
                }else{
                    Toast.makeText(this,"Ingrese un monto mayor a cero.",Toast.LENGTH_LONG).show();
                }
            }else{
                Toast.makeText(this,"Ingrese un monto.",Toast.LENGTH_LONG).show();
            }
        }
    }
}
