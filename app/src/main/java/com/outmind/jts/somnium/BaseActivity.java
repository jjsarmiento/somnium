package com.outmind.jts.somnium;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseActivity extends AppCompatActivity {

    Button btnAdd;
    Button btnDel;
    ListView listMain;

    List<String> items_list;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        btnAdd  = (Button) findViewById(R.id.newItem);
        btnDel = (Button) findViewById(R.id.delItem);
        listMain = (ListView) findViewById(R.id.listMain);

        String[] items = new String[] {
                "Item 1",
                "Jan Awesome"
        };

        items_list = new ArrayList<>(Arrays.asList(items));

        arrayAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, items_list);

        listMain.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(BaseActivity.this, "wtf", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }

    public void newItemInit(View v) {

//        Dialog dialog = new Dialog(v.getContext());
//        dialog.setTitle("Enter text");
//
//        dialog.show();

        items_list.add("ADD MORE");
        listMain.setAdapter(arrayAdapter);
    }
}
