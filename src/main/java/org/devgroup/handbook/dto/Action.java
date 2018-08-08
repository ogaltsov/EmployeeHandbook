package org.devgroup.handbook.dto;

import lombok.*;
import java.util.Date;


// todo: redesign class after redesignin "history" table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Action {
    @NonNull
    private long id;
    @NonNull
    private Date date;
    @NonNull
    private Employee employee;
    @NonNull
    private String action;
    private String ip;
}
