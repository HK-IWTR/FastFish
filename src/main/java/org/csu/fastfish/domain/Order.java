package org.csu.fastfish.domain;

import lombok.Data;

@Data
public class Order {
    private int id;
    private String username;
    private String nata_name;
    private String event_date;
    private String event_time;
    private String order_time;
    private float price;
    private String picture;

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setNata_name(String nata_name) {
        this.nata_name = nata_name;
    }

    public void setEvent_date(String event_date) {
        this.event_date = event_date;
    }

    public void setEvent_time(String event_time) {
        this.event_time = event_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getNata_name() {
        return nata_name;
    }

    public String getEvent_date() {
        return event_date;
    }

    public String getEvent_time() {
        return event_time;
    }

    public String getOrder_time() {
        return order_time;
    }

    public float getPrice() {
        return price;
    }
}
