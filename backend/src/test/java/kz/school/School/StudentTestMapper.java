package kz.school.School;

import kz.school.School.models.Students;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StudentTestMapper {

    @Insert("INSERT INTO students (id, name, surname, bdate, sGroup) VALUES (NULL, #{name}, #{surname}, #{bdate}, #{sGroup});")
    boolean add(Students student);

    @Select("SELECT * FROM students ORDER BY id DESC LIMIT 1")
    Students getLast();

}
