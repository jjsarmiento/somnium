package utilities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.ArrayAdapter;

import com.orm.query.Condition;
import com.orm.query.Select;
import com.outmind.jts.somnium.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import domain.BaseDomain;
import entity.MasterList;
import entity.SubList;

/**
 *
 * Class to hold all boiler-plate codes
 *
 * Created by JTS on 9/4/2017.
 */
public class ActivityUtility {

    private static boolean ALERT_DIALOG_VAL = false;

    public ActivityUtility(){}

    public void start(Activity from, Class to){
        try {
            Intent newIntent = new Intent(from, to);
            from.startActivity(newIntent);
        } catch (Exception e) {
            System.out.print(e.toString());
        }
    }

    public void refreshMasterList(Activity activity) {
        BaseDomain.db_MasterList = Select.from(MasterList.class).orderBy("id desc").list();
        BaseDomain.rvMasterListAdapter = new RvMasterListAdapter((ArrayList<MasterList>) BaseDomain.db_MasterList, activity);
        BaseDomain.rv_main.setAdapter(BaseDomain.rvMasterListAdapter);
    }

    public void refreshSubList(Activity activity) {
        BaseDomain.db_SubList = SubList.findWithQuery(SubList.class, "SELECT * FROM SUB_LIST WHERE MASTER_LIST = " + BaseDomain.singleMasterList.getId().toString() + " ORDER BY ID DESC ");
        System.out.println(BaseDomain.db_SubList);

        /** Using custom adapter */
        BaseDomain.subListAdapter = new SubListAdapter(activity, (ArrayList<SubList>) BaseDomain.db_SubList);
        BaseDomain.lv_sub.setAdapter(BaseDomain.subListAdapter);
    }

    public boolean confirm(Activity activity, String message) {
        new AlertDialog.Builder(activity)
            .setMessage(message)
            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    ALERT_DIALOG_VAL = true;
                }})
            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    ALERT_DIALOG_VAL = false;
                }
            }).show();

        return ALERT_DIALOG_VAL;
    }

}
