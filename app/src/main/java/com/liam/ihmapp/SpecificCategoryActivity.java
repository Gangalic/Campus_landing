package com.liam.ihmapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class SpecificCategoryActivity extends AppCompatActivity {

    ImageView mCheckCouverts;
    ImageView mCheckPoele;
    ImageView mCheckPassoire;
    ImageView mCheckAutre;
    TextView mCategoryTitle;
    ImageButton mCouverts;
    ImageButton mPoele;
    ImageButton mPassoire;

    boolean mCouvertsVisibility = false;
    boolean mPoeleVisibility = false;
    boolean mPassoireVisibility = false;
    boolean mAutreVisibility = false;

    int mObjectSelected = 0;

    private static final String keyIntentCategory = "com.liam.IHMApp.SpecificCategoryActivity.CATEGORY";
    private static final String keyIntentCheck = "com.liam.IHMApp.SpecificCategoryActivity.CHECKED";
    private static final String keyIntentSpecific = "com.liam.IHMApp.SpecificCategoryActivity.SPECIFIC";
    private static final String keyIntentOther = "com.liam.IHMApp.SpecificCategoryActivity.OTHER";
    public static final int NEW_OBJECT_REQUEST = 2;
    private static final String COUVERTS_KEY = "COUVERTS";
    private static final String POELE_KEY = "POELE";
    private static final String PASSOIRE_KEY = "PASSOIRE";
    private static final String AUTRE_KEY = "AUTRE";

    // Shared preferences
    private SharedPreferences mPreferences;
    private static final String sharedPrefFileCuisine = "com.liam.android.IHMApp.CUISINE";
    private static final String sharedPrefFileEntretien = "com.liam.android.IHMApp.ENTRETIEN";
    private static final String sharedPrefFileSport = "com.liam.android.IHMApp.SPORT";
    private static final String sharedPrefFileInformatique = "com.liam.android.IHMApp.INFORMATIQUE";
    private static final String sharedPrefFileVetements = "com.liam.android.IHMApp.VETEMENTS";
    private static final String sharedPrefFileElectromenager = "com.liam.android.IHMApp.ELECTROMENAGER";
    private static final String sharedPrefFileDivers = "com.liam.android.IHMApp.DIVERS";
    private static final String sharedPrefFileLivres = "com.liam.android.IHMApp.LIVRES";

    /**
     * Result for the added object
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == NEW_OBJECT_REQUEST
                && resultCode == RESULT_OK
                && data.hasExtra(keyIntentOther))
        {

                Boolean checkedCategory = data.getBooleanExtra(keyIntentOther,false);
                if(checkedCategory) {
                    mCheckAutre.setVisibility(View.VISIBLE);
                    mAutreVisibility = true;
                    mObjectSelected++;
                }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_category);

        Intent intent = getIntent();

        mCheckCouverts = (ImageView) findViewById(R.id.couvert_check_image);
        mCheckPoele = (ImageView) findViewById(R.id.poele_check_image);
        mCheckPassoire = (ImageView) findViewById(R.id.passoire_check_image);
        mCheckAutre = (ImageView) findViewById(R.id.autre_check_image);
        mCategoryTitle = (TextView) findViewById(R.id.category_title);
        mCouverts = (ImageButton) findViewById(R.id.couvert_button);
        mPoele = (ImageButton) findViewById(R.id.poele_button);
        mPassoire = (ImageButton) findViewById(R.id.passoire_button);

        if(savedInstanceState != null){
            restoreState(savedInstanceState);
        }

        initActivity(intent);
    }

    /**
     * Back to the Categories Selection activity.
     * @param view
     */
    public void backToCategories(View view) {

        SharedPreferences.Editor preferencesEditor = mPreferences.edit();

        // Write the current Count and Color in the Shared Preferences File
        preferencesEditor.putBoolean(COUVERTS_KEY, mCouvertsVisibility);
        preferencesEditor.putBoolean(POELE_KEY,mPoeleVisibility);
        preferencesEditor.putBoolean(PASSOIRE_KEY, mPassoireVisibility);
        preferencesEditor.putBoolean(AUTRE_KEY,mAutreVisibility);

        // Save the preferences
        preferencesEditor.apply();

        Intent intent = new Intent(this, ObjectCategoryActivity.class);

        if(mObjectSelected>0)
            intent.putExtra(keyIntentCheck,mCategoryTitle.getText().toString());

        setResult(RESULT_OK,intent);
        finish();
    }

    /**
     * Restore the last state of the activity
     * @param savedState : the last state data
     */
    public void restoreState(Bundle savedState){
        boolean isCouvertVisible = savedState.getBoolean("couverts_check_visible");
        boolean isPoeleVisible = savedState.getBoolean("poele_check_visible");
        boolean isPassoireVisible = savedState.getBoolean("passoire_check_visible");
        boolean isAutreVisible = savedState.getBoolean("autre_check_visible");

        if (isCouvertVisible) {
            mCheckCouverts.setVisibility(View.VISIBLE);
            mCouvertsVisibility=true;
        }
        if (isPoeleVisible) {
            mCheckPoele.setVisibility(View.VISIBLE);
            mPoeleVisibility=true;
        }
        if (isPassoireVisible) {
            mCheckPassoire.setVisibility(View.VISIBLE);
            mPassoireVisibility=true;
        }
        if (isAutreVisible) {
            mCheckAutre.setVisibility(View.VISIBLE);
            mAutreVisibility=true;
        }
    }

    /**
     * Save the current state of the objects checked
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if (mCheckCouverts.getVisibility() == View.VISIBLE) {
            outState.putBoolean("couverts_check_visible", true);
        }
        if (mCheckPoele.getVisibility() == View.VISIBLE) {
            outState.putBoolean("poele_check_visible", true);
        }
        if (mCheckPassoire.getVisibility() == View.VISIBLE) {
            outState.putBoolean("passoire_check_visible", true);
        }
        if (mCheckAutre.getVisibility() == View.VISIBLE) {
            outState.putBoolean("autre_check_visible", true);
        }
    }

    /**
     * Check the clicked object
     * @param view
     */
    public void checkObjectClicked(View view) {
        switch(view.getId()) {
            case R.id.couvert_button:
                if (mCheckCouverts.getVisibility() != View.VISIBLE) {
                    mCheckCouverts.setVisibility(View.VISIBLE);
                    mCouvertsVisibility=true;
                    mObjectSelected++;
                } else {
                    mCheckCouverts.setVisibility(View.INVISIBLE);
                    mCouvertsVisibility=false;
                    mObjectSelected--;
                }
                break;

            case R.id.poele_button:
                if (mCheckPoele.getVisibility()!=View.VISIBLE) {
                    mCheckPoele.setVisibility(View.VISIBLE);
                    mPoeleVisibility=true;
                    mObjectSelected++;
                }
                else {
                    mCheckPoele.setVisibility(View.INVISIBLE);
                    mPoeleVisibility=false;
                    mObjectSelected--;
                }
                break;

            case R.id.passoire_button:
                if(mCheckPassoire.getVisibility()!=View.VISIBLE) {
                    mCheckPassoire.setVisibility(View.VISIBLE);
                    mPassoireVisibility=true;
                    mObjectSelected++;
                }
                else {
                    mCheckPassoire.setVisibility(View.INVISIBLE);
                    mPassoireVisibility=false;
                    mObjectSelected--;
                }
                break;

            default:
                throw new RuntimeException("Unknow button ID");
        }
    }

    /**
     * Launch the newObject activit to add an unknown object
     * @param view
     */
    public void newObject(View view) {
        Intent intent = new Intent(this, NewObjectActivity.class);
        intent.putExtra(keyIntentCategory,mCategoryTitle.getText().toString());
        startActivityForResult(intent,NEW_OBJECT_REQUEST);
    }

    /**
     * Init the Activity
     * @param intent
     */
    public void initActivity(Intent intent){
        String category = intent.getStringExtra(keyIntentSpecific);
        mCategoryTitle.setText(category);

        //Choose the images to display depending on the category
        if(category.equals("Cuisine")){
            mCouverts.setImageDrawable(getDrawable(R.drawable.couverts));
            mPoele.setImageDrawable(getDrawable(R.drawable.tasse));
            mPassoire.setImageDrawable(getDrawable(R.drawable.pan));
        }
        else if(category.equals("Entretien")){
            mCouverts.setImageDrawable(getDrawable(R.drawable.balais));
            mPoele.setImageDrawable(getDrawable(R.drawable.aspirateur));
            mPassoire.setImageDrawable(getDrawable(R.drawable.produits));
        }
        else if(category.equals("Sport")){
            mCouverts.setImageDrawable(getDrawable(R.drawable.ballon));
            mPoele.setImageDrawable(getDrawable(R.drawable.raquette));
            mPassoire.setImageDrawable(getDrawable(R.drawable.chrono));
        }
        else if(category.equals("Informatique")){
            mCouverts.setImageDrawable(getDrawable(R.drawable.ordi));
            mPoele.setImageDrawable(getDrawable(R.drawable.hdmi));
            mPassoire.setImageDrawable(getDrawable(R.drawable.chargeur));
        }
        else if(category.equals("Électroménager")){
            mCouverts.setImageDrawable(getDrawable(R.drawable.fer));
            mPoele.setImageDrawable(getDrawable(R.drawable.mix));
            mPassoire.setImageDrawable(getDrawable(R.drawable.cafe));
        }
        else if(category.equals("Livres")){
            mCouverts.setImageDrawable(getDrawable(R.drawable.roman));
            mPoele.setImageDrawable(getDrawable(R.drawable.cours));
            mPassoire.setImageDrawable(getDrawable(R.drawable.bd));
        }
        else if(category.equals("Vêtements")){
            mCouverts.setImageDrawable(getDrawable(R.drawable.shirt));
            mPoele.setImageDrawable(getDrawable(R.drawable.casquette));
            mPassoire.setImageDrawable(getDrawable(R.drawable.gants));
        }
        else if(category.equals("Divers")){
            mCouverts.setImageDrawable(getDrawable(R.drawable.chaise));
            mPoele.setImageDrawable(getDrawable(R.drawable.valise));
            mPassoire.setImageDrawable(getDrawable(R.drawable.deguisement));
        }

        // Show or hide the tick
        mPreferences = choosePrefFile(mCategoryTitle.getText().toString());

        mCouvertsVisibility = mPreferences.getBoolean(COUVERTS_KEY, false);
        mPoeleVisibility = mPreferences.getBoolean(POELE_KEY, false);
        mPassoireVisibility = mPreferences.getBoolean(PASSOIRE_KEY, false);
        mAutreVisibility = mPreferences.getBoolean(AUTRE_KEY, false);

        if(mCouvertsVisibility)
            mCheckCouverts.setVisibility(View.VISIBLE);
        if(mPoeleVisibility)
            mCheckPoele.setVisibility(View.VISIBLE);
        if(mPassoireVisibility)
            mCheckPassoire.setVisibility(View.VISIBLE);
        if(mAutreVisibility)
            mCheckAutre.setVisibility(View.VISIBLE);
    }

    public SharedPreferences choosePrefFile(String category){
        if(category.equals("Cuisine"))
            return getSharedPreferences(sharedPrefFileCuisine, MODE_PRIVATE);

        else if(category.equals("Entretien"))
            return getSharedPreferences(sharedPrefFileEntretien, MODE_PRIVATE);

        else if(category.equals("Sport"))
            return getSharedPreferences(sharedPrefFileSport, MODE_PRIVATE);

        else if(category.equals("Informatique"))
            return getSharedPreferences(sharedPrefFileInformatique, MODE_PRIVATE);

        else if(category.equals("Électroménager"))
            return getSharedPreferences(sharedPrefFileElectromenager, MODE_PRIVATE);

        else if(category.equals("Vêtements"))
            return getSharedPreferences(sharedPrefFileVetements, MODE_PRIVATE);

        else if(category.equals("Livres"))
            return getSharedPreferences(sharedPrefFileElectromenager, MODE_PRIVATE);

        else
            return getSharedPreferences(sharedPrefFileDivers, MODE_PRIVATE);
    }
}
