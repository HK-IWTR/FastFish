package org.csu.fastfish.domain;

import lombok.Data;

@Data
public class Good {
    private String good_name;
    private int price;
    private String Description;
    private String picture;
    private int amount;
}
