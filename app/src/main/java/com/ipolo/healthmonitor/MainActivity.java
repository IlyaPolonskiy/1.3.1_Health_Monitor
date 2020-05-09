package com.ipolo.healthmonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText firstName;
    private EditText lastName;
    private EditText age;

    private static final String TAG = "Health";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {
        // Init form
        firstName = findViewById(R.id.editTextFirstName);
        lastName = findViewById(R.id.editTextLastName);
        age = findViewById(R.id.editTextAge);

        // Init button
        Button btnPressure = findViewById(R.id.buttonPressure);
        btnPressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPressure = new Intent(MainActivity.this, AddPressureActivity.class);

                ifIsEmpty(R.string.error_form);
                ifIsNotEmpty(intentPressure);
            }
        });

        Button btnVitalSings = findViewById(R.id.buttonVitalSigns);
        btnVitalSings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVitals = new Intent(MainActivity.this, AddVitalSignsActivity.class);

                ifIsEmpty(R.string.error_form);
                ifIsNotEmpty(intentVitals);
            }
        });
    }

    private void ifIsEmpty(int resources){
        Toast errorToast = Toast.makeText(getApplicationContext(), resources, Toast.LENGTH_LONG);

        if (firstName.getText().length() == 0) errorToast.show();
        else if (lastName.getText().length() == 0) errorToast.show();
        else if (age.getText().length() == 0) errorToast.show();
    }

    private void ifIsNotEmpty(Intent intent){
        if (firstName.getText().length() > 0 && lastName.getText().length() > 0 && age.getText().length() > 0){
            addNewUser();
            startActivity(intent);
        }
    }

    private void addNewUser(){
        User user = new User(
                firstName.getText().toString(),
                lastName.getText().toString(),
                Integer.parseInt(age.getText().toString())
        );
        Log.i(TAG, "Создан пользователь");
    }


}
