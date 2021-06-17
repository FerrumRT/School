package kz.school.School.mappers;

import kz.school.School.models.Teachers;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeachersMapper {
    @Select("SELECT `id`, `name`, `surname`, `email`, `isAdmin` FROM `teachers` WHERE `name` LIKE '%#{search}%' OR `surname` LIKE '%#{search}%'")
    List<Teachers> findAll(String search);

    @Insert("INSERT INTO `teachers` (`id`, `name`, `surname`, `email`, `password`, `isAdmin`) VALUES (NULL, #{name}, #{surname}, #{email}, #{password}, #{isAdmin});")
    boolean add(Teachers teacher);

    @Update("UPDATE `teachers` SET `name` = #{name}, `surname` = #{surname}, `email` = #{email}, `password` = #{password}, `isAdmin` = #{isAdmin} WHERE `teachers`.`id` = #{id};")
    boolean update(Teachers teacher);

    @Delete("DELETE FROM `teachers` WHERE `teachers`.`id` = #{id}")
    boolean delete(int id);

    @Select("SELECT `id`, `name`, `surname`, `email`, `password`, `isAdmin` FROM `teachers` where `id` = #{id}")
    Teachers findOne(int id);

    @Select("SELECT `id`, `name`, `surname`, `email`, `password`, `isAdmin` FROM `teachers` where `email` = #{email}")
    Teachers findOneByEmail(String email);
}
