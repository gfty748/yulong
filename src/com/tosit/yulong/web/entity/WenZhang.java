package com.tosit.yulong.web.entity;

/**
 * Created by zx on 2016/9/26.
 */
public class WenZhang {
    private int wz_id;
    private String wz_title;
    private String wz_content;
    private String wz_img;

    public WenZhang(int wz_id, String wz_title, String wz_content, String wz_img) {
        this.wz_id = wz_id;
        this.wz_title = wz_title;
        this.wz_content = wz_content;
        this.wz_img = wz_img;
    }

    public WenZhang() {
        super();
    }

    public int getWz_id() {
        return wz_id;
    }

    public void setWz_id(int wz_id) {
        this.wz_id = wz_id;
    }

    public String getWz_title() {
        return wz_title;
    }

    public void setWz_title(String wz_title) {
        this.wz_title = wz_title;
    }

    public String getWz_content() {
        return wz_content;
    }

    public void setWz_content(String wz_content) {
        this.wz_content = wz_content;
    }

    public String getWz_img() {
        return wz_img;
    }

    public void setWz_img(String wz_img) {
        this.wz_img = wz_img;
    }
}
