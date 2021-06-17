package kz.school.School.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
public class StudentResponse implements Serializable {
    private static final long serialVersionUID = 987654321L;

    private int id;
    private String name;
    private String surname;
    private Date bdate;
    private String groupName;
}
