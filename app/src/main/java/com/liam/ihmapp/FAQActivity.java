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
    private TextView faq1Title;
    private int faq1Clicked = 0;

    private LinearLayout faq2Layout;
    private ImageView faq2Image;
    private TextView faq2Title;
    private int faq2Clicked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        faq1Layout = (LinearLayout) findViewById(R.id.faq1_layout);
        faq1Image = (ImageView) findViewById(R.id.faq_img_1);
        faq1Title = (TextView) findViewById(R.id.faq1_title);


        faq2Layout = (LinearLayout) findViewById(R.id.faq2_layout);
        faq2Image = (ImageView) findViewById(R.id.faq_img_2);
        faq2Title = (TextView) findViewById(R.id.faq2_title);


    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        initFAQLayout(faq1Layout,faq1Title);
        initFAQLayout(faq2Layout,faq2Title);
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
        faq1Clicked = faqExpandHide(faq1Layout,faq1Image, faq1Title, faq1Clicked);
    }

    public void expandFAQ2(View view) {
        faq2Clicked = faqExpandHide(faq2Layout,faq2Image, faq2Title, faq2Clicked);
    }

    /**
     *
     * @param lay the layout containing the current FAQ
     * @param img the image button of the FAQ
     * @param title the title of the current FAQ
     * @param clicked if the FAQ was already clicked
     * @return the new state of the FAQ
     */
    public int faqExpandHide(LinearLayout lay, ImageView img, TextView title, int clicked){
        switch(clicked) {
            case 0:
                lay.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
                lay.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                img.setImageResource(R.drawable.ic_expand_24dp);
                clicked = 1;
                break;
            case 1:
                lay.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
                initFAQLayout(lay,title);
                img.setImageResource(R.drawable.ic_faq_hidden_24dp);
                clicked = 0;
                break;
        }

        return clicked;
    }

    public void initFAQLayout(LinearLayout lay,TextView title){
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) lay.getLayoutParams();
        params.height = title.getHeight() + 2*lay.getPaddingTop();
        lay.setLayoutParams(params);
    }

}
