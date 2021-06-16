package kz.school.School.mappers;

import kz.school.School.models.Students;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentsMapper {
    @Select("SELECT `id`, `name`, `surname`, `bdate`, `sGroup` from students")
    List<Students> findAll();

    @Insert("INSERT INTO `students` (`id`, `name`, `surname`, `bdate`, `sGroup`) VALUES (NULL, #{name}, #{surname}, #{bdate}, #{s_group});")
    boolean add(Students student);

    @Update("UPDATE `students` SET `name` = #{name}, `surname` = #{surname}, `bdate` = #{bdate}, `sGroup` = #{sGroup} WHERE `id` = #{id};")
    boolean update(Students student);

    @Delete("DELETE FROM `students` WHERE `id` = #{id}")
    boolean delete(int id);

    @Select("SELECT `id`, `name`, `surname`, `bdate`, `s_group` FROM `students` where `id` = #{id}")
    Students findOne(int id);
}
