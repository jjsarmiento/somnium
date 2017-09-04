package entity;

import com.orm.SugarRecord;

/**
 * Created by Phase1 on 9/4/2017.
 */

public class SubList extends SugarRecord<SubList> {

    private Integer sl_id;
    private String sl_title;
    private String sl_description;

    /** 1:1 Relationship with MasterList */
    private MasterList masterList;

    public SubList() {
    }

    public SubList(Integer sl_id, String sl_title, String sl_description, MasterList masterList) {
        this.sl_id = sl_id;
        this.sl_title = sl_title;
        this.sl_description = sl_description;
        this.masterList = masterList;
    }

    public Integer getSl_id() {
        return sl_id;
    }

    public void setSl_id(Integer sl_id) {
        this.sl_id = sl_id;
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
        return masterList;
    }

    public void setMasterList(MasterList masterList) {
        this.masterList = masterList;
    }
}
