package com.outmind.jts.somnium;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utilities.ActivityUtility;

public class BaseActivity extends AppCompatActivity {

    ListView listMain;
    List<String> items_list;
    List<String> contextMenu;
    ArrayAdapter<String> arrayAdapter;

    ActivityUtility au;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        au = new ActivityUtility();

        listMain = (ListView) findViewById(R.id.listMain);

        String[] items = new String[] {
                "Item 1",
                "Jan Awesome"
        };

        items_list = new ArrayList<>(Arrays.asList(items));

        arrayAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, items_list);

//        listMain.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(BaseActivity.this, "wtf", Toast.LENGTH_SHORT).show();
//                return true;
//            }
//        });


        registerForContextMenu(listMain);

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

    /**
     * Adds new item in the listview
     * @param v
     */
    public void newItemInit(View v) {
        items_list.add("ADD MORE");
        listMain.setAdapter(arrayAdapter);
    }
}
