package com.liam.ihmapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SharePointsActivity extends AppCompatActivity {

    private TextView points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_points);

        points = (TextView) findViewById(R.id.pointsShared);
    }

    public void MinusPoint(View view) {
        int count = Integer.parseInt(points.getText().toString()) - 1;
        points.setText(String.valueOf(count));
    }

    public void PlusPoint(View view) {
        int count = Integer.parseInt(points.getText().toString()) + 1;
        points.setText(String.valueOf(count));
    }
}
