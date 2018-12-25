package com.liam.ihmapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ObjectCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_category);

        Intent intent = getIntent();
    }

    public void launchCategory(View view) {
        Intent intent = new Intent(this, SpecificCategoryActivity.class);
        startActivity(intent);
    }
}
