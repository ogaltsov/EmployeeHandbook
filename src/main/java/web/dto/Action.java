package web.dto;

import lombok.*;
import java.util.Date;

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
