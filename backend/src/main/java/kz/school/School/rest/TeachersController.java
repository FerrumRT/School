package kz.school.School.rest;

import kz.school.School.dto.TeacherResponse;
import kz.school.School.mappers.TeachersMapper;
import kz.school.School.models.Teachers;
import kz.school.School.services.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest/teachers")
public class TeachersController {

    @Autowired
    private TeachersService teachersService;

    private TeacherResponse toResponse(Teachers teacher) {
        return (new TeacherResponse(
                teacher.getId(),
                teacher.getName(),
                teacher.getSurname(),
                teacher.getEmail(),
                teacher.isAdmin()
        ));
    }

    private List<TeacherResponse> toResponseList(List<Teachers> teachers) {
        List<TeacherResponse> teacherResponses = new ArrayList<>();
        for (Teachers teacher : teachers) {
            teacherResponses.add(toResponse(teacher));
        }
        return teacherResponses;
    }

    @GetMapping("/all")
    public List<TeacherResponse> getAll() {
        List<Teachers> teachers = teachersService.getAll();
        return toResponseList(teachers);
    }

    @GetMapping("/{id}")
    public TeacherResponse getOne(@PathVariable int id) {
        return toResponse(teachersService.getOne(id));
    }

    @PostMapping("/add")
    public boolean add(@RequestBody Teachers teacher) {
        return teachersService.add(teacher);
    }

    @PutMapping("/update/{id}")
    public boolean update(@PathVariable int id, @RequestBody Teachers teacher) {
        teacher.setId(id);
        return teachersService.update(teacher);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable int id) {
        return teachersService.delete(id);
    }
}
