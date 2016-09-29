package com.tosit.yulong.web.entity;

/**
 * Created by zx on 2016/9/27.
 */
public class JingDian {
    private int jd_id;
    private String jd_name;
    private String jd_description;
    private String jd_img;

    public JingDian(int jd_id, String jd_name, String jd_description, String jd_img) {
        this.jd_id = jd_id;
        this.jd_name = jd_name;
        this.jd_description = jd_description;
        this.jd_img = jd_img;
    }

    public JingDian() {
        super();
    }

    public int getJd_id() {
        return jd_id;
    }

    public void setJd_id(int jd_id) {
        this.jd_id = jd_id;
    }

    public String getJd_name() {
        return jd_name;
    }

    public void setJd_name(String jd_name) {
        this.jd_name = jd_name;
    }

    public String getJd_description() {
        return jd_description;
    }

    public void setJd_description(String jd_description) {
        this.jd_description = jd_description;
    }

    public String getJd_img() {
        return jd_img;
    }

    public void setJd_img(String jd_img) {
        this.jd_img = jd_img;
    }
}
