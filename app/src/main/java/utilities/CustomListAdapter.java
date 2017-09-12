package utilities;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.outmind.jts.somnium.R;

import java.util.List;

import entity.MasterList;

/**
 * Created by Phase1 on 9/6/2017.
 */

public class CustomListAdapter extends RecyclerView.Adapter<CustomListAdapter.ViewHolder> {

    private List<MasterList> mDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public ViewHolder(TextView v) {
            super(v);
            mTextView = v;
        }
    }

    public CustomListAdapter (List<MasterList> listDataSet) {
        mDataSet = listDataSet;
    }

    @Override
    public CustomListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View x = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_text_view, parent, false);
        TextView v = (TextView) x.findViewById(R.id.my_text_view);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(mDataSet.get(position).getMl_title());
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}