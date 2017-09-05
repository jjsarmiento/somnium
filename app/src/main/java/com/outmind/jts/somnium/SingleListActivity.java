package com.outmind.jts.somnium;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ListMenuItemView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import data.OpsDelete;
import domain.BaseDomain;
import entity.MasterList;
import utilities.ActivityUtility;

public class SingleListActivity extends AppCompatActivity {

    Button btnDel;
    OpsDelete opDelete;
    ActivityUtility au;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_list);
        getSupportActionBar().setTitle(BaseDomain.singleMasterList.getMl_title());

        btnDel = (Button) findViewById(R.id.delItem);
        au = new ActivityUtility();
        opDelete = new OpsDelete();
    }

    public void deleteMasterList( View v ) {
        opDelete.deleteMasterList(BaseDomain.singleMasterList.getId());
        au.refreshMasterList(this);
        finish();
    }
}
