package com.liam.ihmapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class ObjectCategoryActivity extends AppCompatActivity {

    private static final String keyIntentCheck = "com.liam.IHMApp.SpecificCategoryActivity.CHECKED";
    private static final String keyIntentSpecific = "com.liam.IHMApp.SpecificCategoryActivity.SPECIFIC";
    public static final int OBJECT_REQUEST = 1;

    private static final String LOG_TAG = MainActivity.class.getSimpleName() +"liam";

    private ImageView mCuisineCheck;
    private ImageView mEntretienCheck;
    private ImageView mSportCheck;
    private ImageView mInformatiqueCheck;
    private ImageView mElectromenagerCheck;
    private ImageView mVetementsCheck;
    private ImageView mLivresCheck;
    private ImageView mDiversCheck;

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == OBJECT_REQUEST) {
            if (resultCode == RESULT_OK) {
                //Check the new category
                if(data.hasExtra(keyIntentCheck)) {
                    String checkedCategory = data.getStringExtra(keyIntentCheck);
                    checkCategory(checkedCategory);
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_category);

        mCuisineCheck = (ImageView) findViewById(R.id.check_cuisine_image);
        mEntretienCheck = (ImageView) findViewById(R.id.check_entretien_image);
        mSportCheck = (ImageView) findViewById(R.id.check_sport_image);
        mInformatiqueCheck = (ImageView) findViewById(R.id.check_informatique_image);
        mElectromenagerCheck = (ImageView) findViewById(R.id.check_electromenager_image);
        mVetementsCheck = (ImageView) findViewById(R.id.check_vetements_image);
        mLivresCheck = (ImageView) findViewById(R.id.check_livres_image);
        mDiversCheck = (ImageView) findViewById(R.id.check_divers_image);

        if(savedInstanceState != null){
            restoreState(savedInstanceState);
        }

        Intent intent = getIntent();
    }

    /**
     * Save the current state of the categories checked
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if (mCuisineCheck.getVisibility() == View.VISIBLE) {
            outState.putBoolean("cuisine_check_visible", true);
        }
        if (mEntretienCheck.getVisibility() == View.VISIBLE) {
            outState.putBoolean("entretien_check_visible", true);
        }
        if (mSportCheck.getVisibility() == View.VISIBLE) {
            outState.putBoolean("sport_check_visible", true);
        }
        if (mInformatiqueCheck.getVisibility() == View.VISIBLE) {
            outState.putBoolean("informatique_check_visible", true);
        }
        if (mElectromenagerCheck.getVisibility() == View.VISIBLE) {
            outState.putBoolean("electromenager_check_visible", true);
        }
        if (mVetementsCheck.getVisibility() == View.VISIBLE) {
            outState.putBoolean("vetements_check_visible", true);
        }
        if (mLivresCheck.getVisibility() == View.VISIBLE) {
            outState.putBoolean("livres_check_visible", true);
        }
        if (mDiversCheck.getVisibility() == View.VISIBLE) {
            outState.putBoolean("divers_check_visible", true);
        }
    }


    /**
     * Restore the last state of the activity
     * @param savedState : the last state data
     */
    public void restoreState(Bundle savedState){

        boolean isCuisineVisible = savedState.getBoolean("cuisine_check_visible");
        boolean isEntretienVisible = savedState.getBoolean("entretien_check_visible");
        boolean isSportVisible = savedState.getBoolean("sport_check_visible");
        boolean isInformatiqueVisible = savedState.getBoolean("informatique_check_visible");
        boolean isElectromenagerVisible = savedState.getBoolean("electromenager_check_visible");
        boolean isVetementsVisible = savedState.getBoolean("vetements_check_visible");
        boolean isLivresVisible = savedState.getBoolean("livres_check_visible");
        boolean isDiversVisible = savedState.getBoolean("divers_check_visible");

        if (isCuisineVisible) {
            mCuisineCheck.setVisibility(View.VISIBLE);
        }
        if (isEntretienVisible) {
            mEntretienCheck.setVisibility(View.VISIBLE);
        }
        if (isSportVisible) {
            mSportCheck.setVisibility(View.VISIBLE);
        }
        if (isInformatiqueVisible) {
            mInformatiqueCheck.setVisibility(View.VISIBLE);
        }
        if (isElectromenagerVisible) {
            mElectromenagerCheck.setVisibility(View.VISIBLE);
        }
        if (isVetementsVisible) {
            mVetementsCheck.setVisibility(View.VISIBLE);
        }
        if (isLivresVisible) {
            mLivresCheck.setVisibility(View.VISIBLE);
        }
        if (isDiversVisible) {
            mDiversCheck.setVisibility(View.VISIBLE);
        }
    }

    /**
     * Launch the selected category
     * @param view
     */
    public void launchCategory(View view) {
        Intent intent = new Intent(this, SpecificCategoryActivity.class);
        switch(view.getId()){
            case R.id.cuisine_button:
                intent.putExtra(keyIntentSpecific,"Cuisine");
                break;

            case R.id.entretien_button:
                intent.putExtra(keyIntentSpecific,"Entretien");
                break;

            case R.id.sport_button:
                intent.putExtra(keyIntentSpecific,"Sport");
                break;

            case R.id.informatique_button:
                intent.putExtra(keyIntentSpecific,"Informatique");
                break;

            case R.id.electromenager_button:
                intent.putExtra(keyIntentSpecific,"Électroménager");
                break;

            case R.id.vetements_button:
                intent.putExtra(keyIntentSpecific,"Vêtements");
                break;

            case R.id.livres_button:
                intent.putExtra(keyIntentSpecific,"Livres");
                break;

            case R.id.divers_button:
                intent.putExtra(keyIntentSpecific,"Divers");
                break;
        }
        startActivityForResult(intent,OBJECT_REQUEST);
    }

    /**
     * Check the visited category if objects were added.
     * @param category
     */
    public void checkCategory(String category){
        if(category.equals("Cuisine")){
            mCuisineCheck.setVisibility(View.VISIBLE);
        }
        else if(category.equals("Entretien")){
            mEntretienCheck.setVisibility(View.VISIBLE);
        }
        else if(category.equals("Sport")){
            mSportCheck.setVisibility(View.VISIBLE);
        }
        else if(category.equals("Électroménager")){
            mElectromenagerCheck.setVisibility(View.VISIBLE);
        }
        else if(category.equals("Informatique")){
            mInformatiqueCheck.setVisibility(View.VISIBLE);
        }
        else if(category.equals("Vêtements")){
            mVetementsCheck.setVisibility(View.VISIBLE);
        }
        else if(category.equals("Livres")){
            mLivresCheck.setVisibility(View.VISIBLE);
        }
        else if(category.equals("Divers")){
            mDiversCheck.setVisibility(View.VISIBLE);
        }
    }

    /**
     * Launch the Profile or the Home Page
     * @param view
     */
    public void finishRegistration(View view) {
        Intent intent = new Intent();

        //Case we were on the profile activity
        if (getCallingActivity() != null) {
            intent = new Intent(this, ProfileActivity.class);
        }

        //Case we are in the Registration
        else{
            intent = new Intent(this, HomePageActivity.class);
        }
        startActivity(intent);

    }
}
