package com.liam.ihmapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class InscriptionPart2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription_part2);
    }

    /**
     * Lauch the third and final part of the Registration form.
     * @param view
     */
    public void launchInscriptionPart3(View view) {
        Intent intent = new Intent(this, InscriptionPart3Activity.class);
        startActivity(intent);
    }
}
