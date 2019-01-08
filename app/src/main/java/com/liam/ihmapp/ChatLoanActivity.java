package com.liam.ihmapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChatLoanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_loan);
    }

    public void backHome(View view) {
        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);
    }

    public void launchGallery(View view) {
        Intent i = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        final int ACTIVITY_SELECT_IMAGE = 1234;
        startActivityForResult(i, ACTIVITY_SELECT_IMAGE);
    }

    public void launchRating(View view) {
        Intent intent = new Intent(this, RatingActivity.class);
        startActivity(intent);
    }

    public void launchLoans(View view) {
        Intent intent = new Intent(this, LoansListActivity.class);
        startActivity(intent);
    }
}
