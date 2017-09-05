package data;

import entity.MasterList;

/**
 * Created by Phase1 on 9/5/2017.
 */

public class OpsDelete {

    public OpsDelete() {
    }

    public boolean deleteMasterList(Long ml_id) {
        try {
            MasterList itemToDelete = MasterList.findById(MasterList.class, ml_id);
            itemToDelete.delete();
            return true;
        } catch ( Exception e ) {
            System.out.println(e.toString());
            return false;
        }
    }
}
