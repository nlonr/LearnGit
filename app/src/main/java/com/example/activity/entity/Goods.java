package com.example.activity.entity;

public class Goods {
    int img;
    String title;
    String content;
    String desc;
    String extra;

    public Goods(int img, String title, String content, String desc, String extra) {
        this.img = img;
        this.title = title;
        this.content = content;
        this.desc = desc;
        this.extra = extra;
    }

    public int getImg() {
        return img;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getDesc() {
        return desc;
    }

    public String getExtra() {
        return extra;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}
