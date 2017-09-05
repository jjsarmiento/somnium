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

import entity.SubList;

/**
 * Created by Phase1 on 9/5/2017.
 */

public class SubListAdapter extends ArrayAdapter<SubList> {

    public SubListAdapter( Context context, ArrayList<SubList> sl ) {
        super(context, 0, sl);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        SubList viewSl = getItem(position);

        if ( convertView == null ) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.cust_master_list, parent, false);
        }

        TextView listName = (TextView) convertView.findViewById(R.id.listName);
        TextView listDesc = (TextView) convertView.findViewById(R.id.listDesc);

        listName.setText(viewSl.getSl_title());
        listDesc.setText(viewSl.getSl_description());

        return convertView;
    }
}
