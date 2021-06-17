package kz.school.School.services;

import kz.school.School.models.Students;

import java.util.List;

public interface StudentsService {
    List<Students> getAll(String search);
    List<Students> getAllById(int id, String search);
    Students getOne(int id);
    boolean add(Students student);
    boolean update(Students student);
    boolean delete(int id);
}
