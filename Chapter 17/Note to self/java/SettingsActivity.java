package com.gamecodeschool.notetoself;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

public class SettingsActivity extends AppCompatActivity {

    private SharedPreferences mPrefs;
    private SharedPreferences.Editor mEditor;

    private boolean mShowDividers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mPrefs = getSharedPreferences("Note to self", MODE_PRIVATE);
        mEditor = mPrefs.edit();

        mShowDividers  = mPrefs.getBoolean("dividers", true);

        Switch switch1 = (Switch) findViewById(R.id.switch1);
        // Set the switch on or off as appropriate
        switch1.setChecked(mShowDividers);

        switch1.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {

                    public void onCheckedChanged(
                            CompoundButton buttonView, boolean isChecked) {

                        if(isChecked){
                            mEditor.putBoolean(
                                    "dividers", true);
                            mShowDividers = true;

                        }else{
                            mEditor.putBoolean(
                                    "dividers", false);
                            mShowDividers = false;

                        }
                    }
                });

    }

    @Override
    protected void onPause() {
        super.onPause();

        // Save the settings here
        mEditor.commit();
    }


}
