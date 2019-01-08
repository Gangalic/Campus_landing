package com.liam.ihmapp;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static java.lang.String.valueOf;

public class WantAThing extends AppCompatActivity {


    private EditText element;
    private EditText period;
    private TextView startDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_want_athing);

        element = findViewById(R.id.object_name_edittext);
        startDate = findViewById(R.id.date_emprunt);
        period = findViewById(R.id.days_edittext);

        //Set the current date for the start date
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
        startDate.setText(dateFormat.format(date));

        element.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (element.getText().toString().length() <= 0) {
                    element.setError("Vous devez indiquez le nom de l'objet");
                } else {
                    element.setError(null);
                }
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
                if (period.getText().toString().length() <= 0) {
                    period.setError("Vous devez indiquez une durée d'emprunt");
                }
                else if(Integer.parseInt(period.getText().toString())<0){
                    period.setError("La durée de l'emprunt est incorrecte");
                } else{
                    period.setError(null);
                }
            }

            // unused but declared
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    /**
     * Check if the different fields are correct
     * @return
     */
    private boolean checkFields(){
        String el = valueOf(element.getText().toString());
        String sDate = valueOf(startDate.getText().toString());
        String per = valueOf(period.getText().toString());

        if (el.length() == 0 || per.length() == 0 || Integer.parseInt(per)<0){
            if (element.getText().toString().trim().equalsIgnoreCase("")) {
                element.setError("Vous devez indiquez le nom de l'objet");
            }
            if (period.getText().toString().trim().equalsIgnoreCase("")) {
                period.setError("Vous devez indiquez une durée d'emprunt");
            }
            if (period.getText().toString().trim().equalsIgnoreCase("")) {
                period.setError("La durée de l'emprunt est incorrecte");
            }
            return false;
        } else {
            return true;
        }
    }

    /**
     * Launch the profile of the user
     * @param view
     */
    public void launchProfil(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    /**
     * Launch the Home page
     * @param view
     */
    public void launchAccueil(View view) {
        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);
    }

    /**
     * Launch the Exchanges of the user
     * @param view
     */
    public void launchExchanges(View view) {
        if (checkFields()) {
            Intent intent = new Intent(this, LoansListActivity.class);
            startActivity(intent);
        }
    }

    /**
     * Update the startDate TextView with the selected date
     * @param year
     * @param month
     * @param day
     */
    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (day_string + "/" + month_string + "/" + year_string);

        startDate.setText(dateMessage);
    }

    /**
     * Launch the DatePicker
     * @param view
     */
    public void pickADate(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }

    public void goBack(View view) {
        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);
    }

    public void sendRequest(View view) {
        Intent intent = new Intent(this, HomePageActivity.class);
        Toast confirmSend = Toast.makeText(this,"Demande envoyée !",Toast.LENGTH_SHORT);
        confirmSend.show();
        startActivity(intent);
    }
}















