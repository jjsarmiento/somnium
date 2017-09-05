package com.outmind.jts.somnium;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ListMenuItemView;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import data.OpsDelete;
import domain.BaseDomain;
import entity.MasterList;
import utilities.ActivityUtility;

public class SingleListActivity extends AppCompatActivity {

    OpsDelete opDelete;
    ActivityUtility au;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_list);
        getSupportActionBar().setTitle(BaseDomain.singleMasterList.getMl_title());

        au = new ActivityUtility();
        opDelete = new OpsDelete();

        /** Initialize Sublist */
        BaseDomain.lv_sub = (ListView) findViewById(R.id.lv_sublist);
        au.refreshSubList(this);

//        /** List item click listener */
//        BaseDomain.lv_sub.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                BaseDomain.singleMasterList = BaseDomain.list_adapter.getItem(i);
//                au.start(SingleListActivity.this, EditSubListItemActivity.class);
//            }
//        });
//
//        /** Register listview for contextmenu */
//        registerForContextMenu(BaseDomain.lv_sub);
    }

    public void addSubListItem( View v ) {
        au.start(this, AddSubListItemActivity.class);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if ( v.getId() == R.id.lv_sublist ) {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
            for (int i = 0; i< BaseDomain.ML_CONMENU_ITEMS.length; i++) {
                menu.add( Menu.NONE, i, i, BaseDomain.ML_CONMENU_ITEMS[i] );
            }
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
//        return super.onContextItemSelected(item);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        BaseDomain.singleMasterList = BaseDomain.list_adapter.getItem(info.position);
        switch ( item.getItemId() ) {
            case 0 :
                break;
            case 1 :
                break;
            case 2 :
                break;
        }
        return true;
    }

}
