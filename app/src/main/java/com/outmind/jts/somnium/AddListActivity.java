package com.outmind.jts.somnium;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import domain.BaseDomain;

public class AddListActivity extends AppCompatActivity {

    Button addBtn;
    EditText title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_list);
        getSupportActionBar().setTitle(getResources().getString(R.string.st_list_add));

        addBtn = (Button) findViewById(R.id.addBtn);
        title = (EditText) findViewById(R.id.et_title);
    }

    public void addNewListToMain(View v) {
        BaseDomain.addNewItemOnList(title.getText().toString());
        finish();
    }
}
