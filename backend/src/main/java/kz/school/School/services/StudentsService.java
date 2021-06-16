package kz.school.School.services;

import kz.school.School.models.Students;

import java.util.List;

public interface StudentsService {
    List<Students> getAll();
    Students getOne(int id);
    boolean add(Students student);
    boolean update(Students student);
    boolean delete(int id);
}
