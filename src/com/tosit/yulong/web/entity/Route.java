package com.tosit.yulong.web.entity;

/**
 * Created by zx on 2016/9/28.
 */
public class Route {
    private int r_id;
    private String r_name;
    private String r_description;
    private String r_img;

    public Route() {
        super();
    }

    public Route(int r_id, String r_name, String r_description, String r_img) {
        this.r_id = r_id;
        this.r_name = r_name;
        this.r_description = r_description;
        this.r_img = r_img;
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }

    public String getR_description() {
        return r_description;
    }

    public void setR_description(String r_description) {
        this.r_description = r_description;
    }

    public String getR_img() {
        return r_img;
    }

    public void setR_img(String r_img) {
        this.r_img = r_img;
    }
}
