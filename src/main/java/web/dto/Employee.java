package web.dto;

import lombok.*;
import javax.swing.text.Position;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    @NonNull
    private long id;
    @NonNull
    private String name;
    @NonNull
    private String surname;
    private String patronimyc;
    @NonNull
    private Gender gender;
    @NonNull
    private Date birthDate;
    @NonNull
    private Department department;
    @NonNull
    private Position position;
    @NonNull
    private int grade;
    @NonNull
    private BigDecimal salary;
    private List<Certificate> certificates;

}
