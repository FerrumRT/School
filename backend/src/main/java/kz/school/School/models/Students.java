package kz.school.School.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Students {
    private int id;
    private String name;
    private String surname;
    private Date bdate;
    private int sGroup;
}
