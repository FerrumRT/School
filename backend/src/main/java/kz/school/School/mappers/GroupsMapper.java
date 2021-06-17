package kz.school.School.mappers;

import kz.school.School.models.Groups;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GroupsMapper {
    @Select("SELECT `id`, `name`, `teacher` FROM groups WHERE `name` LIKE #{search}")
    List<Groups> findAll(String search);

    @Insert("INSERT INTO `groups` (`id`, `name`, `teacher`) VALUES (NULL, #{name}, #{teacher});")
    boolean add(Groups group);

    @Update("UPDATE `groups` SET `name` = #{name}, `teacher` = #{teacher} WHERE `id` = #{id};")
    boolean update(Groups group);

    @Delete("DELETE FROM `groups` WHERE `id` = #{id}")
    boolean delete(int id);

    @Select("SELECT `id`, `name`, `teacher` FROM `groups` where `id` = #{id}")
    Groups findOne(int id);

    @Select("SELECT `id`, `name`, `teacher` FROM `groups` where `teacher` = #{id}")
    List<Groups> findAllByTeacherId(int id);
}
