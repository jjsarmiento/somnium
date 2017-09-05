package com.outmind.jts.somnium;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import domain.BaseDomain;
import entity.MasterList;
import utilities.ActivityUtility;

public class EditMainListActivity extends AppCompatActivity {

    EditText mlTitle;
    EditText mlDesc;
    ActivityUtility au;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_main_list);
        getSupportActionBar().setTitle("Edit");

        au = new ActivityUtility();

        mlTitle = (EditText) findViewById(R.id.mlTitle);
        mlDesc = (EditText) findViewById(R.id.mlDescription);

        mlTitle.setText(BaseDomain.singleMasterList.getMl_title());
        mlDesc.setText(BaseDomain.singleMasterList.getMl_description());

    }

    public void doEdit( View v ) {
        BaseDomain.singleMasterList.setMl_title(mlTitle.getText().toString());
        BaseDomain.singleMasterList.setMl_description(mlDesc.getText().toString());
        BaseDomain.singleMasterList.save();
        au.refreshMasterList(this);
        finish();
    }
}
