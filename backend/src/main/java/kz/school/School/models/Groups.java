package kz.school.School.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Groups {
    private int id;
    private String name;
    private int teacher;
}
