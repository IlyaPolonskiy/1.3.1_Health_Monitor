package com.ipolo.healthmonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;


public class AddPressureActivity extends AppCompatActivity {

    private EditText topPressure;
    private EditText lowPressure;
    private EditText heartRate;
    private CheckBox tachycardia;
    private Button save;
    private TextView descPressure;


    private static final String TAG = "Health";
    private static  final int LONG_DELAY = 7000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pressure);

        init();
    }

    public void init(){
        descPressure = findViewById(R.id.textViewDescriptionPressure);
        topPressure = findViewById(R.id.editTextATopPressure);
        lowPressure = findViewById(R.id.editTextLowerPressure);
        heartRate =  findViewById(R.id.editTextHeartRate);
        tachycardia = findViewById(R.id.checkBoxTachycardia);

        descPressure.setText(getString(R.string.description_pressure));

        save = findViewById(R.id.buttonSavePressure);
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

        if (topPressure.getText().length() == 0) errorToast.show();
        else if (lowPressure.getText().length() == 0) errorToast.show();
        else if (heartRate.getText().length() == 0) errorToast.show();
    }

    private void ifIsNotEmpty(){
        if (topPressure.getText().length() > 0 && lowPressure.getText().length() > 0 && heartRate.getText().length() > 0) {

            ArrayList<Pressure> pressureList = new ArrayList<Pressure>();
            pressureList.add(new Pressure(
                    Integer.parseInt(topPressure.getText().toString()),
                    Integer.parseInt(lowPressure.getText().toString()),
                    Integer.parseInt(heartRate.getText().toString()),
                    tachycardia.isChecked(),
                    Calendar.getInstance().getTime()));


            Log.i(TAG, "Показания добавлены в список.");

            Toast successToast = Toast.makeText(getApplicationContext(), pressureList.toString(), Toast.LENGTH_LONG);
            successToast.show();

            finish();
        }
    }


}
