package com.tosit.yulong.web.entity;

/**
 * Created by Administrator on 2016/9/28 0028.
 */
public class Ticket {
    private int t_id;
    private String t_name;
    private String t_description;
    private String t_img;
    private int t_price;

    public Ticket() {
        super();
    }

    public Ticket(int t_id, String t_name, String t_description, String t_img, int t_price) {
        this.t_id = t_id;
        this.t_name = t_name;
        this.t_description = t_description;
        this.t_img = t_img;
        this.t_price = t_price;
    }

    public Ticket(int t_id, String t_name, int t_price) {
        this.t_id = t_id;
        this.t_name = t_name;
        this.t_price = t_price;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getT_description() {
        return t_description;
    }

    public void setT_description(String t_description) {
        this.t_description = t_description;
    }

    public String getT_img() {
        return t_img;
    }

    public void setT_img(String t_img) {
        this.t_img = t_img;
    }

    public int getT_price() {
        return t_price;
    }

    public void setT_price(int t_price) {
        this.t_price = t_price;
    }
}
