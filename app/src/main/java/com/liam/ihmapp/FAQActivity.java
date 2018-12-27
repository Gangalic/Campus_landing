package com.liam.ihmapp;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FAQActivity extends AppCompatActivity {

    private LinearLayout faq1Layout;
    private ImageView faq1Image;
    private TextView faq1Answer;
    private int faq1Clicked = 0;

    private LinearLayout faq2Layout;
    private ImageView faq2Image;
    private TextView faq2Answer;
    private int faq2Clicked = 0;

    private LinearLayout faq3Layout;
    private ImageView faq3Image;
    private TextView faq3Answer;
    private int faq3Clicked = 0;

    private LinearLayout faq4Layout;
    private ImageView faq4Image;
    private TextView faq4Answer;
    private int faq4Clicked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        faq1Layout = (LinearLayout) findViewById(R.id.faq1_layout);
        faq1Image = (ImageView) findViewById(R.id.faq_img_1);
        faq1Answer = (TextView) findViewById(R.id.faq_answer1);

        faq2Layout = (LinearLayout) findViewById(R.id.faq2_layout);
        faq2Image = (ImageView) findViewById(R.id.faq_img_2);
        faq2Answer = (TextView) findViewById(R.id.faq_answer2);

        faq3Layout = (LinearLayout) findViewById(R.id.faq3_layout);
        faq3Image = (ImageView) findViewById(R.id.faq_img_3);
        faq3Answer = (TextView) findViewById(R.id.faq3_answer);

        faq4Layout = (LinearLayout) findViewById(R.id.faq4_layout);
        faq4Image = (ImageView) findViewById(R.id.faq_img_4);
        faq4Answer = (TextView) findViewById(R.id.faq4_answer);

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

    //-------FAQ Click events ---------------------

    public void expandFAQ1(View view) {
        faq1Clicked = faqExpandHide(faq1Layout,faq1Image, faq1Answer, faq1Clicked);
    }

    public void expandFAQ2(View view) {
        faq2Clicked = faqExpandHide(faq2Layout,faq2Image, faq2Answer, faq2Clicked);
    }

    public void expandFAQ3(View view) {
        faq3Clicked = faqExpandHide(faq3Layout,faq3Image, faq3Answer, faq3Clicked);
    }

    public void expandFAQ4(View view) {
        faq4Clicked = faqExpandHide(faq4Layout,faq4Image, faq4Answer, faq4Clicked);
    }

    /**
     *
     * @param lay the layout containing the current FAQ
     * @param img the image button of the FAQ
     * @param answer the answer of the current FAQ
     * @param clicked if the FAQ was already clicked
     * @return the new state of the FAQ
     */
    public int faqExpandHide(LinearLayout lay, ImageView img, TextView answer, int clicked){
        switch(clicked) {
            case 0:
                lay.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
                answer.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                img.setImageResource(R.drawable.ic_expand_white_24dp);
                clicked = 1;
                break;
            case 1:
                lay.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
                answer.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0));
                img.setImageResource(R.drawable.ic_hide_white_24dp);
                clicked = 0;
                break;
        }

        return clicked;
    }



}
