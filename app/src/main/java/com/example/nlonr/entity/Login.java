package com.example.nlonr.entity;

public class Login{
    private String status;
    private String msg;
    private String Uid;

    private String id;
    private String username;
    private String password;
    private String email;
    private String icon;
    private String type;

    public Login(String status, String msg, String uid, String id, String username, String password, String email, String icon, String type) {
        this.status = status;
        this.msg = msg;
        Uid = uid;
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.icon = icon;
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public String getUid() {
        return Uid;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getIcon() {
        return icon;
    }

    public String getType() {
        return type;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setUid(String uid) {
        Uid = uid;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setType(String type) {
        this.type = type;
    }
}
