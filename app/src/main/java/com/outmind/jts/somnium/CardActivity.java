package com.outmind.jts.somnium;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.orm.query.Select;

import domain.BaseDomain;
import entity.MasterList;
import utilities.CustomListAdapter;

public class CardActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        mRecyclerView = (RecyclerView) findViewById(R.id.cv);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        BaseDomain.db_MasterList = Select.from(MasterList.class).orderBy("id desc").list();

        // specify an adapter (see also next example)
        mAdapter = new CustomListAdapter(BaseDomain.db_MasterList);
        mRecyclerView.setAdapter(mAdapter);

    }
}
