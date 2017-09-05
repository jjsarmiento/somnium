package com.outmind.jts.somnium;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import domain.BaseDomain;
import entity.MasterList;
import utilities.ActivityUtility;

public class AddSubListItemActivity extends AppCompatActivity {

    EditText title;
    EditText desc;
    ActivityUtility au;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sub_list_item);
        getSupportActionBar().setTitle("Add item to " + BaseDomain.singleMasterList.getMl_title());

        au = new ActivityUtility();
        title = (EditText) findViewById(R.id.et_sl_title);
        desc = (EditText) findViewById(R.id.et_sl_desc);
    }

    public void doAdd( View v ) {
        BaseDomain.addNewSubItemOnList(title.getText().toString(), desc.getText().toString());
        au.refreshSubList(this);
        Toast.makeText(this, "Successfully added", Toast.LENGTH_SHORT).show();
        finish();
    }
}
