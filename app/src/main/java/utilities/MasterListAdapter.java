package utilities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.outmind.jts.somnium.R;

import java.util.ArrayList;

import entity.MasterList;

/**
 * Created by Phase1 on 9/5/2017.
 */

public class MasterListAdapter extends ArrayAdapter<MasterList> {

    public MasterListAdapter(Context context, ArrayList<MasterList> ml) {
        super(context, 0, ml);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        MasterList viewMl = getItem(position);

        if( convertView == null ) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.cust_master_list, parent, false);
        }

        TextView listName = (TextView) convertView.findViewById(R.id.listName);
        TextView listDesc = (TextView) convertView.findViewById(R.id.listDesc);

        listName.setText(viewMl.getMl_title());
        listDesc.setText(viewMl.getMl_description_short());

        return convertView;
    }
}
