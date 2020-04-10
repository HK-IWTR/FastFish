package org.csu.fastfish.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Notice {
    private int nana_id;
    private String title;
    private String detail;
    private Date notice_time;
}
