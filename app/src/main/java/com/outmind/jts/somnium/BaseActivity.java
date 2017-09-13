package com.outmind.jts.somnium;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import domain.BaseDomain;
import utilities.ActivityUtility;

public class BaseActivity extends AppCompatActivity {

    ActivityUtility au;
    ActionMode deleteActionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        this.setTitle("");

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
                deleteActionMode = this.startActionMode(deleteActionModeCallBack);
                this.getWindow().getDecorView().findViewById(android.R.id.content).setSelected(true);
                break;
            case R.id.tm_verBtn :
                au.dialog("Somnium is developed by" + getResources().getString(R.string.app_author_name) + " \nApp version : " + getResources().getString(R.string.app_version_number) , this);
                break;
        }
        return true;
    }

    private ActionMode.Callback deleteActionModeCallBack = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.delete_amode_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            Toast.makeText(BaseActivity.this, item.getItemId(), Toast.LENGTH_SHORT).show();
            mode.finish();
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            deleteActionMode = null;
        }
    };
}
