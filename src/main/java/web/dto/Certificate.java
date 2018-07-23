package web.dto;

import lombok.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Certificate {
    @NonNull
    private long id;
    @NonNull
    private Date date;
    @NonNull
    private String company;
    @NonNull
    private String name;
    @NonNull
    private Long number;
    private byte[] scan;
}
