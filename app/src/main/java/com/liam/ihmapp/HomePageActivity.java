package com.liam.ihmapp;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import java.io.IOException;

public class HomePageActivity extends AppCompatActivity {

    private RelativeLayout notif1;
    private RelativeLayout notif2;
    private RelativeLayout notif3;
    private RelativeLayout notif4;
    private RelativeLayout notif5;
    private RelativeLayout notif6;
    private RelativeLayout notif7;
    private RelativeLayout notif8;
    private RelativeLayout notif9;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        notif1 = (RelativeLayout) findViewById(R.id.notif_1);
        notif2 = (RelativeLayout) findViewById(R.id.notif_2);
        notif3 = (RelativeLayout) findViewById(R.id.notif_3);
        notif4 = (RelativeLayout) findViewById(R.id.notif_4);
        notif5 = (RelativeLayout) findViewById(R.id.notif_5);
        notif6 = (RelativeLayout) findViewById(R.id.notif_6);
        notif7 = (RelativeLayout) findViewById(R.id.notif_7);
        notif8 = (RelativeLayout) findViewById(R.id.notif_8);
        notif9 = (RelativeLayout) findViewById(R.id.notif_9);

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
        //Do nothing because you are already on the home page
    }

    public void launchExchanges(View view) {
        Intent intent = new Intent(this, LoansListActivity.class);
        startActivity(intent);
    }

    public void launchChat(View view) {
        Intent intent = new Intent(this, ChatActivity.class);
        startActivity(intent);
    }

    public void removeNotification1(View view) {
       notif1.setVisibility(View.GONE);
    }

    public void removeNotification2(View view) {
        notif2.setVisibility(View.GONE);
    }
    public void removeNotification3(View view) {
        notif3.setVisibility(View.GONE);
    }
    public void removeNotification4(View view) {
        notif4.setVisibility(View.GONE);
    }
    public void removeNotification5(View view) {
        notif5.setVisibility(View.GONE);
    }
    public void removeNotification6(View view) {
        notif6.setVisibility(View.GONE);
    }
    public void removeNotification7(View view) {
        notif7.setVisibility(View.GONE);
    }
    public void removeNotification8(View view) {
        notif8.setVisibility(View.GONE);
    }
    public void removeNotification9(View view) {
        notif9.setVisibility(View.GONE);
    }
}
