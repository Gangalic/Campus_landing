package com.liam.ihmapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class NewObjectActivity extends AppCompatActivity {

    private EditText mNewObject;
    private boolean mObjectAdded = false;

    private static final String keyIntentOther = "com.liam.IHMApp.SpecificCategoryActivity.OTHER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_object);

        Intent intent = getIntent();

        mNewObject = (EditText) findViewById(R.id.new_object_edittext);

        mNewObject.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (mNewObject.getText().toString().length() <= 0) {
                    mNewObject.setError("L\'objet doit avoir un nom");
                } else {
                    mNewObject.setError(null);
                }
            }

            // Implemented but unused
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    public void backToSpecificCategory(View view) {
        Intent intent = new Intent(this, SpecificCategoryActivity.class);
        setResult(RESULT_OK,intent);
        finish();
    }

    public boolean checkObjectName(){
        if(mNewObject.getText().toString().length()<=0){
            if (mNewObject.getText().toString().trim().equalsIgnoreCase("")) {
                mNewObject.setError("L\'objet doit avoir un nom");
            }
            return false;
        }
        else
            return true;
    }

    public void addNewObject(View view) {
        if(checkObjectName()) {
            mObjectAdded = true;
            Intent intent = new Intent(this, SpecificCategoryActivity.class);
            intent.putExtra(keyIntentOther,mObjectAdded);
            setResult(RESULT_OK,intent);
            finish();
        }
    }
}
