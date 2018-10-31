package com.gamecodeschool.devicedetection;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtOrientation;
    private TextView txtResolution;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get a reference to our TextView widgets
        txtOrientation = (TextView) findViewById(R.id.txtOrientation);
        txtResolution = (TextView) findViewById(R.id.txtResolution);

    }

    public void detectDevice(View v){

        // What is the orientation?
        Display display = getWindowManager().getDefaultDisplay();
        txtOrientation.setText("" + display.getRotation());

        // What is the resolution?
        Point xy = new Point();
        display.getSize(xy);
        txtResolution.setText("x = " + xy.x + " y = " + xy.y);

    }

}
