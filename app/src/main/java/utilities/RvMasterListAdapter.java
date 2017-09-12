package utilities;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.outmind.jts.somnium.R;

import java.util.ArrayList;

import entity.MasterList;

/**
 * Created by Phase1 on 9/7/2017.
 */

public class RvMasterListAdapter extends RecyclerView.Adapter<RvMasterListAdapter.RvMasterListViewHolder> {

    ArrayList<MasterList> masterList;

    public RvMasterListAdapter(ArrayList<MasterList> masterListList) {
        masterList = masterListList;
    }

    @Override
    public RvMasterListAdapter.RvMasterListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card, parent, false);
        RvMasterListViewHolder viewHolder = new RvMasterListViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RvMasterListViewHolder holder, int position) {
        holder.tvName.setText(masterList.get(position).getMl_title());
        holder.tvDesc.setText(masterList.get(position).getMl_description());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return masterList.size();
    }

    public static class RvMasterListViewHolder extends RecyclerView.ViewHolder {

        protected TextView tvName;
        protected TextView tvDesc;
        protected View view;
        protected CardView cardView;

        public RvMasterListViewHolder(View v) {
            super(v);
            tvName = (TextView) v.findViewById(R.id.listName);
            tvDesc = (TextView) v.findViewById(R.id.listDesc);
            cardView = (CardView) v.findViewById(R.id.cv);
        }

    }

}
