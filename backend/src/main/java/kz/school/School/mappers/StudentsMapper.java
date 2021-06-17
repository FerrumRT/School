package kz.school.School.mappers;

import kz.school.School.models.Students;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentsMapper {
    @Select("SELECT `id`, `name`, `surname`, `bdate`, `sGroup` FROM students WHERE `name` LIKE #{search} OR `surname` LIKE #{search}")
    List<Students> findAll(String search);

    @Insert("INSERT INTO `students` (`id`, `name`, `surname`, `bdate`, `sGroup`) VALUES (NULL, #{name}, #{surname}, #{bdate}, #{sGroup});")
    boolean add(Students student);

    @Update("UPDATE `students` SET `name` = #{name}, `surname` = #{surname}, `bdate` = #{bdate}, `sGroup` = #{sGroup} WHERE `id` = #{id};")
    boolean update(Students student);

    @Delete("DELETE FROM `students` WHERE `id` = #{id}")
    boolean delete(@Param("id") int id);

    @Select("SELECT `id`, `name`, `surname`, `bdate`, `s_group` FROM `students` where `id` = #{id}")
    Students findOne(int id);

    @Select("SELECT `id`, `name`, `surname`, `bdate`, `sGroup` FROM students WHERE `sGroup` = #{id} AND (`name` LIKE #{search} OR `surname` LIKE #{search})")
    List<Students> findAllById(int id, String search);

    @Select("SELECT * FROM students ORDER BY id DESC LIMIT 1")
    Students getLast();
}
