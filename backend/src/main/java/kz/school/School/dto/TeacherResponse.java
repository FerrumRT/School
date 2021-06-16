package kz.school.School.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Data
public class TeacherResponse implements Serializable {
    private static final long serialVersionUID = 987654321L;

    private int id;
    private String name;
    private String surname;
    private String email;
    private boolean isAdmin;
}
