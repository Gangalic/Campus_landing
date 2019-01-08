package com.liam.ihmapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SharePointsActivity extends AppCompatActivity {

    private TextView points;
    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_points);

        points = (TextView) findViewById(R.id.pointsShared);
        email = (EditText) findViewById(R.id.email_to_send);

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (email.getText().toString().length() <= 0) {
                    email.setError("Vous devez renseigner l\'email du destinataire");
                } else {
                    email.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    public void MinusPoint(View view) {
        int count = Integer.parseInt(points.getText().toString()) - 1;
        points.setText(String.valueOf(count));
    }

    public void PlusPoint(View view) {
        int count = Integer.parseInt(points.getText().toString()) + 1;
        points.setText(String.valueOf(count));
    }

    public void sendPoints(View view) {
        if(checkEmail()){
            Toast confirmSend = Toast.makeText(this,points.getText().toString() + " points envoyés !",Toast.LENGTH_SHORT);
            confirmSend.show();
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        }
    }

    private boolean checkEmail(){
        String mail = email.getText().toString();

        if (mail.length() == 0){
            if (email.getText().toString().trim().equalsIgnoreCase("")) {
                email.setError("Vous devez renseigner l'email de votre ami");
            }
            return false;
        } else {
            return true;
        }
    }

    public void backToSettings(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }
}
