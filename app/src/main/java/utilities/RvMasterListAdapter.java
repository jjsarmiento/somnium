package utilities;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.outmind.jts.somnium.R;

import java.util.ArrayList;

import domain.BaseDomain;
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
        final RvMasterListViewHolder viewHolder = new RvMasterListViewHolder(v);

        // click listener of cardview
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Create new activity
            }
        });

        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return masterList.size();
    }

    @Override
    public void onBindViewHolder(RvMasterListViewHolder holder, int position) {
        holder.tvName.setText(masterList.get(position).getMl_title());
        holder.tvDesc.setText(masterList.get(position).getMl_description());
    }

    /**
     * Implements ContextMenu tools
     */
    public static class RvMasterListViewHolder extends RecyclerView.ViewHolder implements RecyclerView.OnCreateContextMenuListener {

        protected TextView tvName;
        protected TextView tvDesc;
        protected View view;
        protected CardView cardView;

        public RvMasterListViewHolder(View v) {
            super(v);
            tvName = (TextView) v.findViewById(R.id.listName);
            tvDesc = (TextView) v.findViewById(R.id.listDesc);
            cardView = (CardView) v.findViewById(R.id.cv);

            v.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            for (String menuItem : BaseDomain.ML_CONMENU_ITEMS) {
                contextMenu.add(menuItem);
            }
        }
    }

}
