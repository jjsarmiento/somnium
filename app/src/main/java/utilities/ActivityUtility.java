package utilities;

import android.app.Activity;
import android.content.Intent;
import android.widget.ArrayAdapter;

import com.orm.query.Select;
import com.outmind.jts.somnium.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import domain.BaseDomain;
import entity.MasterList;

/**
 *
 * Class to hold all boiler-plate codes
 *
 * Created by JTS on 9/4/2017.
 */
public class ActivityUtility {

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
//        BaseDomain.db_MasterList = MasterList.listAll(MasterList.class);
        BaseDomain.db_MasterList = Select.from(MasterList.class).orderBy("id desc").list();

        /** Using custom adapter */
        BaseDomain.list_adapter = new MasterListAdapter(activity, (ArrayList<MasterList>) BaseDomain.db_MasterList);
        BaseDomain.lv_main.setAdapter(BaseDomain.list_adapter);

        /** Using ArrayAdapter */
//        BaseDomain.list_adapter = new ArrayAdapter<>(activity, android.R.layout.simple_list_item_1, BaseDomain.db_MasterList);
//        BaseDomain.lv_main.setAdapter(BaseDomain.list_adapter);
    }

    public void toListView(Class<Class> obj) {

    }

}
