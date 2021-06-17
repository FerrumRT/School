package kz.school.School.services.impl;

import kz.school.School.mappers.StudentsMapper;
import kz.school.School.models.Students;
import kz.school.School.services.StudentsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsServiceImpl implements StudentsService {

    private final StudentsMapper studentsMapper;

    public StudentsServiceImpl(StudentsMapper studentsMapper) {
        this.studentsMapper = studentsMapper;
    }

    @Override
    public List<Students> getAll(String search) {
        return studentsMapper.findAll(search);
    }

    @Override
    public List<Students> getAllById(int id, String search) {
        search = "%" + search + "%";
        return studentsMapper.findAllById(id, search);
    }

    @Override
    public Students getOne(int id) {
        return studentsMapper.findOne(id);
    }

    @Override
    public boolean add(Students student) {
        return studentsMapper.add(student);
    }

    @Override
    public boolean update(Students student) {
        Students old_student = studentsMapper.findOne(student.getId());
        if (student.getBdate() == null) student.setBdate(old_student.getBdate());
        if (student.getName() == null) student.setName(old_student.getName());
        if (student.getSurname() == null) student.setSurname(old_student.getSurname());
        return studentsMapper.update(student);
    }

    @Override
    public boolean delete(int id) {
        if(studentsMapper.delete(id)) System.out.println("Deleted");
        else System.out.println("Not deleted");
        return studentsMapper.delete(id);
    }
}
