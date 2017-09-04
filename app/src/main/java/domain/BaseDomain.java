package domain;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.outmind.jts.somnium.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JTS on 9/4/2017.
 */

public class BaseDomain {

    public static List<String>          list_main;
    public static ArrayAdapter<String>  list_adapter;
    public static ListView              lv_main;
    public static Integer               ind_list_index;

    public static void addNewItemOnList(String content){
        list_main.add(0, content);
        BaseDomain.lv_main.setAdapter(BaseDomain.list_adapter);
    }

}
