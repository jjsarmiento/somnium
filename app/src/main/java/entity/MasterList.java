package entity;

import com.orm.SugarRecord;

/**
 * Created by Phase1 on 9/4/2017.
 */

public class MasterList extends SugarRecord<MasterList> {

    private Integer ml_id;
    private String ml_title;
    private String ml_description;

    public MasterList() { }

    public MasterList(String ml_title, String ml_description) {
//        this.ml_id = ml_id;
        this.ml_title = ml_title;
        this.ml_description = ml_description;
    }

    public Integer getMl_id() {
        return ml_id;
    }

    public void setMl_id(Integer ml_id) {
        this.ml_id = ml_id;
    }

    public String getMl_title() {
        return ml_title;
    }

    public void setMl_title(String ml_title) {
        this.ml_title = ml_title;
    }

    public String getMl_description() {
        return ml_description;
    }

    public void setMl_description(String ml_description) {
        this.ml_description = ml_description;
    }
}
