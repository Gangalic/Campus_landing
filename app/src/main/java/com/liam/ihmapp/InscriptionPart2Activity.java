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
                if (password.getText().toString().length() <= 0) {
                    password.setError("Vous devez renseigner un mot de passe");
                } else {
                    password.setError(null);
                }
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
                if (repeatPassword.getText().toString().length() <= 0) {
                    repeatPassword.setError("Vous devez confirmer votre mot de passe");
                } else {
                    repeatPassword.setError(null);
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

    // check to have matching non-empty passwords
    private boolean checkFields(){
        String pass1 = valueOf(password.getText().toString());
        String pass2 = valueOf(repeatPassword.getText().toString());

        if (pass1.length() == 0 || pass2.length() == 0){
            if (password.getText().toString().trim().equalsIgnoreCase("")) {
                password.setError("Vous devez renseigner un mot de passe");
            }
            if (repeatPassword.getText().toString().trim().equalsIgnoreCase("")) {
                repeatPassword.setError("Vous devez confirmer votre mot de passe");
            }
            return false;
        }
        else if(!pass1.equals(pass2)){
            errorMessage.setText("Les mots de passe ne correspondent pas!");
            return false;
        } else{
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

    public void launchBack(View view) {
        Intent intent = new Intent(this, InscriptionPart1Activity.class);
        startActivity(intent);
    }
}
