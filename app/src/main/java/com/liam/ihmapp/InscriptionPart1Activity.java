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
