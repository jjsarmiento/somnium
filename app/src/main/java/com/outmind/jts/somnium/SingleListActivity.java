package com.outmind.jts.somnium;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ListMenuItemView;
import android.widget.TextView;

import domain.BaseDomain;

public class SingleListActivity extends AppCompatActivity {

    TextView tv_listTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_list);
        String listView = BaseDomain.list_adapter.getItem(BaseDomain.ind_list_index);
        getSupportActionBar().setTitle(listView);
    }
}
