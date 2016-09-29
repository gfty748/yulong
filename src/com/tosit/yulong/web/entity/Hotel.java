package com.tosit.yulong.web.entity;

/**
 * Created by zx on 2016/9/26.
 */
public class Hotel {
    private int hotelId;
    private String hotelName;
    private String description;
    private String hotelImg;

    public Hotel() {
        super();
    }

    public Hotel(int hotelId, String hotelName, String description, String hotelImg) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.description = description;
        this.hotelImg = hotelImg;
    }

    public int getHotelId() {

        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHotelImg() {
        return hotelImg;
    }

    public void setHotelImg(String hotelImg) {
        this.hotelImg = hotelImg;
    }
}
