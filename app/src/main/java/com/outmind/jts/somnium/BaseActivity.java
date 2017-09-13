package com.outmind.jts.somnium;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.Toast;

import domain.BaseDomain;
import utilities.ActivityUtility;

public class BaseActivity extends AppCompatActivity {

    ActivityUtility au;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        BaseDomain.ML_CONMENU_ITEMS = getResources().getStringArray(R.array.conmen_array);
        BaseDomain.SL_CONMENU_ITEMS = getResources().getStringArray(R.array.conmen_sub_array);

        BaseDomain.rv_main = (RecyclerView) findViewById(R.id.rv);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        BaseDomain.rv_main.setLayoutManager(mLayoutManager);

        au = new ActivityUtility();
        au.refreshMasterList(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.topmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.tm_newList :
                au.start(BaseActivity.this, AddListActivity.class);
                break;
            case R.id.tm_delList :
                break;
            case R.id.tm_verBtn :
                au.dialog("Somnium is developed by" + getResources().getString(R.string.app_author_name) + " \nApp version : " + getResources().getString(R.string.app_version_number) , this);
                break;
        }
        return true;
    }
}
