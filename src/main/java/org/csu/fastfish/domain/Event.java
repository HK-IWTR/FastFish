package org.csu.fastfish.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Event {
    private int nana_id;
    private Date event_time;
    private int max_people;
    private int reserved_people;

}
