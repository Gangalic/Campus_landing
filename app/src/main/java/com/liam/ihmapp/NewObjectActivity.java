package com.liam.ihmapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NewObjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_object);

        Intent intent = getIntent();
    }

    public void backToSpecificCategory(View view) {
        Intent intent = new Intent(this, SpecificCategoryActivity.class);
        startActivity(intent);
    }

    public void addNewObject(View view) {
        Intent intent = new Intent(this, SpecificCategoryActivity.class);
        startActivity(intent);
    }
}
