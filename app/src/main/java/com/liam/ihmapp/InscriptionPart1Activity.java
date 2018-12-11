package com.liam.ihmapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class InscriptionPart1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription_part1);

        Intent intent = getIntent();
    }

    /**
     * Lauch the Part2 of the Registration Form
     * @param view
     */
    public void lauchInscriptionPart2(View view) {
        Intent intent = new Intent(this, InscriptionPart2Activity.class);
        startActivity(intent);
    }
}
