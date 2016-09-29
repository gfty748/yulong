package com.tosit.yulong.web.entity;

/**
 * Created by zx on 2016/9/26.
 */
public class LanMu {
    private int lm_id;
    private String lm_name;

    public LanMu(int lm_id, String lm_name) {
        this.lm_id = lm_id;
        this.lm_name = lm_name;
    }

    public int getLm_id() {
        return lm_id;
    }

    public void setLm_id(int lm_id) {
        this.lm_id = lm_id;
    }

    public String getLm_name() {
        return lm_name;
    }

    public void setLm_name(String lm_name) {
        this.lm_name = lm_name;
    }

    public LanMu() {
        super();
    }
}
