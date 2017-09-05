package domain;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.outmind.jts.somnium.BaseActivity;
import com.outmind.jts.somnium.R;

import java.util.ArrayList;
import java.util.List;

import entity.MasterList;
import utilities.MasterListAdapter;

/**
 * Created by JTS on 9/4/2017.
 */

public class BaseDomain {

    /** B: Constants */
    public static final Integer             SUBSTR_MAXLENGTH = 30;
    /** E: Constants */

    /** B: Context Menu Items */
    public static String[]                  ML_CONMENU_ITEMS;
    /** E: Context Menu Items */

    public static MasterListAdapter         list_adapter;
    public static ListView                  lv_main;
    public static Integer                   ind_list_index;
    public static List<MasterList>          db_MasterList;
    public static MasterList                singleMasterList;

    public static void addNewItemOnList(String title, String description){
        (new MasterList(title, description)).save();
    }

}
