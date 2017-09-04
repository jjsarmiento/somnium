package utilities;

import android.app.Activity;
import android.content.Intent;

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

}
