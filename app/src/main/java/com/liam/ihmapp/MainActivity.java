package com.liam.ihmapp;

import android.content.Intent;
import android.content.SharedPreferences;
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

    // Shared preferences
    private SharedPreferences mPreferences;
    private static final String sharedPrefFileCuisine = "com.liam.android.IHMApp.CUISINE";
    private static final String sharedPrefFileEntretien = "com.liam.android.IHMApp.ENTRETIEN";
    private static final String sharedPrefFileSport = "com.liam.android.IHMApp.SPORT";
    private static final String sharedPrefFileInformatique = "com.liam.android.IHMApp.INFORMATIQUE";
    private static final String sharedPrefFileVetements = "com.liam.android.IHMApp.VETEMENTS";
    private static final String sharedPrefFileElectromenager = "com.liam.android.IHMApp.ELECTROMENAGER";
    private static final String sharedPrefFileDivers = "com.liam.android.IHMApp.DIVERS";
    private static final String sharedPrefFileLivres = "com.liam.android.IHMApp.LIVRES";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resetSharedPrefFile();

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

    /**
     * Reset all the shared preferences files (for object selection check)
     */
    public void resetSharedPrefFile(){
        SharedPreferences cuisineFile = getSharedPreferences(sharedPrefFileCuisine, MODE_PRIVATE);
        cuisineFile.edit().clear().apply();

        SharedPreferences entretienFile = getSharedPreferences(sharedPrefFileEntretien, MODE_PRIVATE);
        entretienFile.edit().clear().apply();

        SharedPreferences sportFile = getSharedPreferences(sharedPrefFileSport, MODE_PRIVATE);
        sportFile.edit().clear().apply();

        SharedPreferences informatiqueFile = getSharedPreferences(sharedPrefFileInformatique, MODE_PRIVATE);
        informatiqueFile.edit().clear().apply();

        SharedPreferences electromenagerFile = getSharedPreferences(sharedPrefFileElectromenager, MODE_PRIVATE);
        electromenagerFile.edit().clear().apply();

        SharedPreferences vetementsFile = getSharedPreferences(sharedPrefFileVetements, MODE_PRIVATE);
        vetementsFile.edit().clear().apply();

        SharedPreferences livresFile = getSharedPreferences(sharedPrefFileLivres, MODE_PRIVATE);
        livresFile.edit().clear().apply();

        SharedPreferences diversFile = getSharedPreferences(sharedPrefFileDivers, MODE_PRIVATE);
        diversFile.edit().clear().apply();
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
