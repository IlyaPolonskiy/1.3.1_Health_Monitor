package com.ipolo.healthmonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class AddVitalSignsActivity extends AppCompatActivity {

    private EditText weight;
    private EditText steps;
    private Button save;

    private static final String  TAG = "Health";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vital_signs);

        init();
    }

    private void init(){
        weight = findViewById(R.id.editTextWeight);
        steps = findViewById(R.id.editTextSteps);

        save = findViewById(R.id.buttonSaveVitals);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ifIsEmpty(R.string.error_form);
                ifIsNotEmpty();
            }
        });
    }

    private void ifIsEmpty(int resources){
        Toast errorToast = Toast.makeText(getApplicationContext(), resources, Toast.LENGTH_LONG);
        if (weight.getText().length() == 0) errorToast.show();
        else if (steps.getText().length() == 0) errorToast.show();
    }

    private void ifIsNotEmpty(){
        if (weight.getText().length() > 0 && steps.getText().length() > 0){
            ArrayList<VitalSign> vitalSigns = new ArrayList<VitalSign>();
            vitalSigns.add(new VitalSign(
                    Integer.parseInt(weight.getText().toString()),
                    Integer.parseInt(steps.getText().toString())));

            Toast successToast = Toast.makeText(getApplicationContext(), vitalSigns.toString(), Toast.LENGTH_LONG);
            successToast.show();

            Log.i(TAG, "Жизненные показатели добавлены.");

            finish();
        }
    }
}

