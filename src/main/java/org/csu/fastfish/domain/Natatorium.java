package org.csu.fastfish.domain;

import lombok.Data;

@Data
public class Natatorium {
    private int id;
    private String nata_name;
    private String telnumber;
    private String description;
    private String picture;
    private String address;
    private float price;
    private float grade;
}
