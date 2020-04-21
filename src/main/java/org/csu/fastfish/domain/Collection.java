package org.csu.fastfish.domain;

import lombok.Data;

@Data
public class Collection {
    private int id;
    private int nata_id;
    private String username;

    public int getId() {
        return id;
    }

    public int getNata_id() {
        return nata_id;
    }

    public String getUsername() {
        return username;
    }
}
