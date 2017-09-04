package com.outmind.jts.somnium;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import domain.BaseDomain;
import utilities.ActivityUtility;

public class BaseActivity extends AppCompatActivity {

    ListView lv_listMain;
    ActivityUtility au;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        au = new ActivityUtility();

        lv_listMain = (ListView) findViewById(R.id.listMain);
        BaseDomain.lv_main = lv_listMain;

        BaseDomain.list_main = new ArrayList<>();
        BaseDomain.list_adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, BaseDomain.list_main);

        /** Manual code for long-click listener of the list view */
//        lv_listMain.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(BaseActivity.this, "wtf", Toast.LENGTH_SHORT).show();
//                return true;
//            }
//        });

        /** List item click listener */
        BaseDomain.lv_main.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                BaseDomain.ind_list_index = i;
                au.start(BaseActivity.this, SingleListActivity.class);
            }
        });

        /** Code for the setting of adapter of the listview */
        BaseDomain.lv_main.setAdapter(BaseDomain.list_adapter);

        /** Register listview for contextmenu */
        registerForContextMenu(BaseDomain.lv_main);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.topmenu, menu);
        return true;
    }

    /**
     *
     * handles menu select event
     *
     * @param item
     * @return
     */
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.tm_newList :
                au.start(BaseActivity.this, AddListActivity.class);
                break;
            case R.id.tm_delList :
                break;
            case R.id.tm_verBtn :
                break;
        }
        return true;
    }

    /**
     *
     * Creates context menu for the listview's indivudual item
     *
     * @param menu
     * @param v
     * @param menuInfo
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v.getId() == R.id.listMain) {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
            String[] conmen_contents = getResources().getStringArray(R.array.conmen_array);
            for (int i = 0; i< conmen_contents.length; i++) {
                menu.add( Menu.NONE, i, i, conmen_contents[i] );
            }
        }
    }
}
