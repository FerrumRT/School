package kz.school.School.services;

import kz.school.School.models.Groups;

import java.util.List;

public interface GroupsService {
    List<Groups> getAll(String search);
    Groups getOne(int id);
    boolean add(Groups group);
    boolean update(Groups group);
    boolean delete(int id);

    List<Groups> getAllByTeacherId(int id);
}
