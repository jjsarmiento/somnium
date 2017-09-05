package domain;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.outmind.jts.somnium.BaseActivity;
import com.outmind.jts.somnium.R;

import java.util.ArrayList;
import java.util.List;

import entity.MasterList;
import entity.SubList;
import utilities.MasterListAdapter;
import utilities.SubListAdapter;

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

    /** B: Master List Variables */
    public static MasterListAdapter         list_adapter;
    public static ListView                  lv_main;
    public static List<MasterList>          db_MasterList;
    public static MasterList                singleMasterList;
    /** E: Master List Variables */

    /** B: Master List Variables */
    public static SubListAdapter            subListAdapter;
    public static ListView                  lv_sub;
    public static List<SubList>             db_SubList;
    public static MasterList                singleSubList;
    /** E: Master List Variables */

    public static void addNewItemOnList(String title, String description){
        (new MasterList(title, description)).save();
    }

    public static void addNewSubItemOnList(String title, String description) {
        ( new SubList(title, description, BaseDomain.singleMasterList.getId()) ).save();
    }

}
