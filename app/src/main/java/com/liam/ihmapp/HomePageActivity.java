package com.liam.ihmapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Intent intent = getIntent();
    }

    public void launchProfile(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    public void launchNewRequest(View view) {
        Intent intent = new Intent(this, WantAThing.class);
        startActivity(intent);
    }

    public void launchHomePage(View view) {
        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);
    }

    public void launchExchanges(View view) {
        Intent intent = new Intent(this, LoansListActivity.class);
        startActivity(intent);
    }
}
