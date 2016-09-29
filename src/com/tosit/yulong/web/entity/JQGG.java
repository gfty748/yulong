package com.tosit.yulong.web.entity;

/**
 * 景区公告实体类
 */
public class JQGG {

    private Integer id;
    private String  title;
    private String content;
    private String time;
    private String img;

    public JQGG() {

    }

    public JQGG(String content, String time) {
        this.content = content;
        this.time = time;
    }

    public JQGG(Integer id, String title, String content, String time,String img) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.time = time;
        this.img = img;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}
