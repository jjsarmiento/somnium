package entity;

import com.orm.SugarRecord;

/**
 * Created by Phase1 on 9/4/2017.
 */

public class SubList extends SugarRecord<SubList> {

    private String sl_title;
    private String sl_description;

    /** 1:1 Relationship with MasterList */
    private Long masterList;

    public SubList() {
    }

    public SubList(String sl_title, String sl_description, Long masterList) {
        this.sl_title = sl_title;
        this.sl_description = sl_description;
        this.masterList = masterList;
    }

    public String getSl_title() {
        return sl_title;
    }

    public void setSl_title(String sl_title) {
        this.sl_title = sl_title;
    }

    public String getSl_description() {
        return sl_description;
    }

    public void setSl_description(String sl_description) {
        this.sl_description = sl_description;
    }

    public MasterList getMasterList() {
        return MasterList.findById(MasterList.class, masterList);
    }

    public void setMasterList(Long masterList) {
        this.masterList = masterList;
    }
}
