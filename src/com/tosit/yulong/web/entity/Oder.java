package com.tosit.yulong.web.entity;

/**
 * Created by zx on 2016/9/30.
 */
public class Oder {
    private String id;
    private String userName;
    private String phone;
    private String certificate;
    private String goods;
    private int total;

    public Oder(String id, String userName, String phone, String certificate, String goods, int total) {
        this.id = id;
        this.userName = userName;
        this.phone = phone;
        this.certificate = certificate;
        this.goods = goods;
        this.total = total;
    }

    public Oder() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
