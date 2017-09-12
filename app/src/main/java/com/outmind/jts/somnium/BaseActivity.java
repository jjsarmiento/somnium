package com.outmind.jts.somnium;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;

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

        BaseDomain.rv_main.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
            }
        });

        /** Register listview for contextmenu */
        registerForContextMenu(BaseDomain.rv_main);
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
        if ( v.getId() == R.id.rv ) {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
            for (int i = 0; i< BaseDomain.ML_CONMENU_ITEMS.length; i++) {
                menu.add( Menu.NONE, i, i, BaseDomain.ML_CONMENU_ITEMS[i] );
            }
        }
    }
}
