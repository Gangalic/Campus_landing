package com.liam.ihmapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SpecificCategoryActivity extends AppCompatActivity {

    ImageView mCheckCouverts;
    ImageView mCheckPoele;
    ImageView mCheckPassoire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_category);

        Intent intent = getIntent();

        mCheckCouverts = (ImageView) findViewById(R.id.couvert_check_image);
        mCheckPoele = (ImageView) findViewById(R.id.poele_check_image);
        mCheckPassoire = (ImageView) findViewById(R.id.passoire_check_image);
    }

    public void backToCategories(View view) {
        Intent intent = new Intent(this, ObjectCategoryActivity.class);
        startActivity(intent);
    }

    public void checkObject(View view) {
        switch(view.getId())
        {
            case R.id.couvert_button:
                if(mCheckCouverts.getVisibility()!=View.VISIBLE)
                    mCheckCouverts.setVisibility(View.VISIBLE);
                else
                    mCheckCouverts.setVisibility(View.INVISIBLE);
                break;
            case R.id.poele_button:
                if(mCheckPoele.getVisibility()!=View.VISIBLE)
                    mCheckPoele.setVisibility(View.VISIBLE);
                else
                    mCheckPoele.setVisibility(View.INVISIBLE);
                break;
            case R.id.passoire_button:
                if(mCheckPassoire.getVisibility()!=View.VISIBLE)
                    mCheckPassoire.setVisibility(View.VISIBLE);
                else
                    mCheckPassoire.setVisibility(View.INVISIBLE);
                break;
            default:
                throw new RuntimeException("Unknow button ID");
        }
    }

    public void newObject(View view) {
        Intent intent = new Intent(this, NewObjectActivity.class);
        startActivity(intent);
    }
}
