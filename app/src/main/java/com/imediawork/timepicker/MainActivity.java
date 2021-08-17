package com.imediawork.timepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timePicker = findViewById(R.id.picker);
        findViewById(R.id.check_picker).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i(TAG, "current hour: " + timePicker.getCurrentHour() + ", minute: " + timePicker.getCurrentMinute());
            }
        });
    }
}