package com.liam.ihmapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import static java.lang.String.valueOf;

public class InscriptionPart1Activity extends AppCompatActivity {
    private EditText firstName;
    private EditText lastName;
    private EditText eMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription_part1);

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        eMail = findViewById(R.id.INSAMail);

        firstName.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setEmail();
                firstName.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            }

            // unused but declared
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable s) {}
        });

        lastName.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setEmail();
                lastName.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            }

            // unused but declared
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable s) {}
        });

        Intent intent = getIntent();
    }

    private void setEmail(){

        String fName = valueOf(firstName.getText().toString());
        String lName = valueOf(lastName.getText().toString());

        eMail.setText(fName + "." + lName);
        eMail.setBackgroundColor(getResources().getColor(R.color.colorWhite));
    }

    private boolean checkFields(){
        String fName = valueOf(firstName.getText().toString());
        String lName = valueOf(lastName.getText().toString());
        String mail = valueOf(eMail.getText().toString());

        if (fName.length() == 0 || lName.length() == 0){
            if(fName.length() == 0)
                firstName.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            if(lName.length() == 0)
                lastName.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            if(mail.length() == 0)
                eMail.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            return false;
        } else {
            return true;
        }
    }

    /**
     * Lauch the Part2 of the Registration Form
     * @param view
     */
    public void launchInscriptionPart2(View view) {
        if(checkFields()) {
            Intent intent = new Intent(this, InscriptionPart2Activity.class);
            startActivity(intent);
        }
    }
}
