package com.liam.ihmapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RatingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
    }

    public void returnChatFinish(View view) {
        Intent intent = new Intent(this, ChatLoanActivity.class);
        startActivity(intent);
    }

    public void launchHome(View view) {
        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);
    }
}
