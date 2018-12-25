package com.liam.ihmapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.mailEditText);
        password = findViewById(R.id.password);

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (email.getText().toString().length() <= 0) {
                    email.setError("Enter FirstName");
                } else {
                    email.setError(null);
                }
            }

            // unused but declared
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable s) {}
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (password.getText().toString().length() <= 0) {
                    password.setError("Enter FirstName");
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

        Intent intent =  getIntent();

    }

    public void LogIn(View view) {
        if(checkFields()) {
            Intent intent = new Intent(this, HomePageActivity.class);
            startActivity(intent);
        }
    }

    private boolean checkFields(){
        String mail = valueOf(email.getText().toString());
        String pass = valueOf(password.getText().toString());
        if (mail.length() == 0 || pass.length() == 0){
            if (email.getText().toString().trim().equalsIgnoreCase("")) {
                email.setError("L\'email doit être renseigné");
            }
            if (password.getText().toString().trim().equalsIgnoreCase("")) {
                password.setError("Le mot de passe doit être renseigné");
            }
            return false;
        } else {
            return true;
        }
    }

    /**
     * Launch the Register Form Part 1 for a new user.
     * @param view
     */
    public void RegisterForm(View view) {
        Intent intent = new Intent(this, InscriptionPart1Activity.class);
        startActivity(intent);
    }
}
