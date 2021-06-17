package kz.school.School.rest;

import kz.school.School.dto.StudentResponse;
import kz.school.School.models.Groups;
import kz.school.School.models.Students;
import kz.school.School.services.GroupsService;
import kz.school.School.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/rest/students")
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    @Autowired
    private GroupsService groupsService;

    private StudentResponse toResponse(Students student) {
        Groups group = groupsService.getOne(student.getSGroup());
        return (new StudentResponse(
                student.getId(),
                student.getName(),
                student.getSurname(),
                student.getBdate(),
                group.getName()
        ));
    }

    private List<StudentResponse> toResponseList(List<Students> students) {
        List<StudentResponse> studentResponses = new ArrayList<>();
        for (Students student : students) {
            studentResponses.add(toResponse(student));
        }
        return studentResponses;
    }

    @GetMapping("/all")
    public List<StudentResponse> getAll(@RequestParam(name = "search") String search) {
        if (search == null) search = "";
        List<Students> students = studentsService.getAll(search);
        return toResponseList(students);
    }

    @GetMapping("/all/{id}")
    public List<StudentResponse> getAllById(@PathVariable int id, @RequestParam(name = "search") String search) {
        if (search == null) search = "";
        List<Students> students = studentsService.getAll(search);
        return toResponseList(students);
    }

    @GetMapping("/{id}")
    public StudentResponse getOne(@PathVariable int id) {
        return toResponse(studentsService.getOne(id));
    }

    @PostMapping("/add")
    public boolean add(@RequestBody Students student) {
        return studentsService.add(student);
    }

    @PutMapping("/update/{id}")
    public boolean update(@PathVariable int id, @RequestBody Students student) {
        student.setId(id);
        return studentsService.update(student);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable int id) {
        return studentsService.delete(id);
    }
}
