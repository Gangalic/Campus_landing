package com.liam.ihmapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.String.valueOf;

public class InscriptionPart2Activity extends AppCompatActivity {

    private EditText password;
    private EditText repeatPassword;
    private TextView errorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription_part2);

        password = findViewById(R.id.insertPassword);
        repeatPassword = findViewById(R.id.repeatPassword);
        errorMessage = findViewById(R.id.passwordErrorMessage);

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                errorMessage.setText("");
                repeatPassword.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            }

            // unused but declared
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable s) {}
        });

        repeatPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                errorMessage.setText("");
                repeatPassword.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            }

            // unused but declared
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable s) {}
        });


        Intent intent = getIntent();
    }

    // check to have matching non-empty passwords
    private boolean checkFields(){
        String pass1 = valueOf(password.getText().toString());
        String pass2 = valueOf(repeatPassword.getText().toString());

        if (pass1.length() == 0 || pass2.length() == 0 || !pass1.equals(pass2)){
            errorMessage.setText("Les mots de passe ne correspondent pas!");
            repeatPassword.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            return false;
        } else {
            return true;
        }
    }

    /**
     * Lauch the third and final part of the Registration form.
     * @param view
     */
    public void launchInscriptionPart3(View view) {
        if (checkFields()) {
            Intent intent = new Intent(this, InscriptionPart3Activity.class);
            startActivity(intent);
        }
    }
}
