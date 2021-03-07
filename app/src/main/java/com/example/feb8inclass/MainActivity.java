package com.example.feb8inclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {

    double conversionRate = 2.2;
    double weightEntered;
    double convertedWeight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText weight = (EditText) findViewById(R.id.editTextNumberDecimal);
        final RadioButton radioButton1 = (RadioButton) findViewById(R.id.radioButton);
        final RadioButton radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        final TextView result = (TextView) findViewById(R.id.textView2 );
        Button convert = (Button) findViewById(R.id.button);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weightEntered = Double.parseDouble(weight.getText().toString());
                DecimalFormat tenth = new DecimalFormat(("#.#"));
                if(weightEntered <=500){
                    if (radioButton1.isChecked()){
                        convertedWeight = weightEntered/conversionRate;
                        result.setText(tenth.format(convertedWeight)+"Kilograms");}
                    else{convertedWeight = weightEntered*conversionRate;
                        result.setText(tenth.format(convertedWeight)+"Pounds");}
                }
                else{
                    Toast.makeText(MainActivity.this, "Be careful, weight<=500", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}