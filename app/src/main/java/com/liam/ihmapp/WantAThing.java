package com.liam.ihmapp;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.String.valueOf;

public class WantAThing extends AppCompatActivity {


    private EditText element;
    private EditText period;
    private TextView startDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_want_athing);

        element = findViewById(R.id.editText8);
        startDate = findViewById(R.id.date_emprunt);
        period = findViewById(R.id.editText7);

        element.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                element.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            }

            // unused but declared
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable s) {}
        });

        startDate.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                startDate.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            }

            // unused but declared
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable s) {}
        });

        period.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                period.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            }

            // unused but declared
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private boolean checkFields(){
        String el = valueOf(element.getText().toString());
        String sDate = valueOf(startDate.getText().toString());
        String per = valueOf(period.getText().toString());

        if (el.length() == 0 || sDate.length() == 0 || per.length() == 0){
            if(el.length() == 0)
                element.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            if(sDate.length() == 0)
                startDate.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            if(per.length() == 0)
                period.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            return false;
        } else {
            return true;
        }
    }

    public void launchProfil(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    public void launchAccueil(View view) {
        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);
    }

    public void launchExchanges(View view) {
        if (checkFields()) {
            Intent intent = new Intent(this, LoansListActivity.class);
            startActivity(intent);
        }
    }

    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (day_string + "/" + month_string + "/" + year_string);

        startDate.setText(dateMessage);
    }

    public void pickADate(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"Sélectionnez une date");
    }
}















