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
                if (firstName.getText().toString().length() <= 0) {
                    firstName.setError("Vous devez renseigner votre prénom");
                } else {
                    firstName.setError(null);
                }
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
                if (lastName.getText().toString().length() <= 0) {
                    lastName.setError("Vous devez renseigner votre nom");
                } else {
                    lastName.setError(null);
                }
            }

            // unused but declared
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable s) {}
        });

        eMail.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (eMail.getText().toString().length() <= 0) {
                    eMail.setError("Vous devez renseigner votre Email");
                } else {
                    eMail.setError(null);
                }
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

        String fName = valueOf(firstName.getText().toString()).toLowerCase();
        String lName = valueOf(lastName.getText().toString()).toLowerCase();

        eMail.setText(fName + "." + lName);
    }

    private boolean checkFields(){
        String fName = valueOf(firstName.getText().toString());
        String lName = valueOf(lastName.getText().toString());
        String mail = valueOf(eMail.getText().toString());

        if (fName.length() == 0 || lName.length() == 0){
            if (firstName.getText().toString().trim().equalsIgnoreCase("")) {
                firstName.setError("Vous devez renseigner votre prénom");
            }
            if (lastName.getText().toString().trim().equalsIgnoreCase("")) {
                lastName.setError("Vous devez renseigner votre nom");
            }
            if (eMail.getText().toString().trim().equalsIgnoreCase("")) {
                eMail.setError("Vous devez renseigner votre email");
            }
            return false;
        } else {
            return true;
        }
    }

    /**
     * Launch the Part2 of the Registration Form
     * @param view
     */
    public void launchInscriptionPart2(View view) {
        if(checkFields()) {
            Intent intent = new Intent(this, InscriptionPart2Activity.class);
            startActivity(intent);
        }
    }

    /**
     * Come back to the initial page MainActivity
     * @param view
     */
    public void launchBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
