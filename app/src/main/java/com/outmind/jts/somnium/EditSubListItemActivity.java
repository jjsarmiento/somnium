package com.outmind.jts.somnium;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import domain.BaseDomain;

public class EditSubListItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_sub_list_item);
        getSupportActionBar().setTitle("Edit " + BaseDomain.singleSubList.getSl_title());
    }
}
