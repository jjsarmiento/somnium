package utilities;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.outmind.jts.somnium.EditMainListActivity;
import com.outmind.jts.somnium.MainActivity;
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
        protected ActivityUtility au;

        public RvMasterListViewHolder(View v) {
            super(v);
            au = new ActivityUtility();
            tvName = (TextView) v.findViewById(R.id.listName);
            tvDesc = (TextView) v.findViewById(R.id.listDesc);
            cardView = (CardView) v.findViewById(R.id.cv);

            v.setOnCreateContextMenuListener(this);

        }

        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            for (int i = 0; i < BaseDomain.ML_CONMENU_ITEMS.length; i++) {
                MenuItem conMen = contextMenu.add(Menu.NONE, i, i, BaseDomain.ML_CONMENU_ITEMS[i]);
                conMen.setOnMenuItemClickListener(onClickContextMenuitem);
            }
        }

        private final MenuItem.OnMenuItemClickListener onClickContextMenuitem = new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                BaseDomain.singleMasterList = BaseDomain.db_MasterList.get(getAdapterPosition());
                switch (menuItem.getItemId()) {
                    case 0 :
                        // TODO Edit
                        au.start(BaseDomain.currentActivity, EditMainListActivity.class);
                        break;
                    case 1 :
                        // TODO Mark as favorite function
                        break;
                    case 2 :
                        // TODO Delete function
                        break;
                    default:
                        break;
                }
                return false;
            }
        };
    }

}
