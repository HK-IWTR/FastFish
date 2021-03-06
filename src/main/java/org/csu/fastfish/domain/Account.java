package org.csu.fastfish.domain;

import lombok.Data;

@Data
public class Account {
    private int id;
    private String username;
    private String password;
    private String phonenumber;
    private String email;
    private String address;
    private String photo;
    private float money;
    private int point;

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoto() {
        return photo;
    }

    public float getMoney() {
        return money;
    }

    public int getPoint() {
        return point;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
