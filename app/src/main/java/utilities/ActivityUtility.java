package utilities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.orm.query.Select;
import java.util.ArrayList;
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
    private Activity activity;

    public ActivityUtility(){
        this.activity = BaseDomain.currentActivity;
    }

    public ActivityUtility(Activity activity) {
        BaseDomain.currentActivity = activity;
        this.activity = activity;
    }

    public void start(Class to){
        try {
            Intent newIntent = new Intent(this.activity, to);
            this.activity.startActivity(newIntent);
        } catch (Exception e) {
            System.out.print(e.toString());
        }
    }

    public void refreshMasterList(Activity activity) {
        BaseDomain.db_MasterList = Select.from(MasterList.class).orderBy("id desc").list();
        BaseDomain.rvMasterListAdapter = new RvMasterListAdapter((ArrayList<MasterList>) BaseDomain.db_MasterList);
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

    public void dialog(String message, Context context) {
        android.support.v7.app.AlertDialog.Builder alertDialogBuilder = new android.support.v7.app.AlertDialog.Builder(context);
        alertDialogBuilder.setMessage(message);
//        alertDialogBuilder.setPositiveButton("OK",
//                new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface arg0, int arg1) {
//                        Toast.makeText(, "", Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//        alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                finish();
//            }
//        });

        android.support.v7.app.AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}
