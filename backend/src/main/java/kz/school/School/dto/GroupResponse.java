package kz.school.School.dto;

import kz.school.School.models.Students;
import kz.school.School.models.Teachers;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class GroupResponse implements Serializable {
    private static final long serialVersionUID = 987654321L;

    private int id;
    private String name;
    private Teachers teacher;
    private List<Students> students;
}
