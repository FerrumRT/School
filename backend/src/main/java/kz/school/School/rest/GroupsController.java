package kz.school.School.rest;

import kz.school.School.dto.GroupResponse;
import kz.school.School.models.Groups;
import kz.school.School.models.Students;
import kz.school.School.models.Teachers;
import kz.school.School.services.GroupsService;
import kz.school.School.services.StudentsService;
import kz.school.School.services.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/rest/groups")
public class GroupsController {

    @Autowired
    private StudentsService studentsService;

    @Autowired
    private GroupsService groupsService;

    @Autowired
    private TeachersService teachersService;

    private GroupResponse toResponse(Groups group, String search) {
        Teachers teacher = teachersService.getOne(group.getTeacher());
        List<Students> students = studentsService.getAllById(group.getId(), search);
        return (new GroupResponse(
                group.getId(),
                group.getName(),
                teacher,
                students
        ));
    }

    private List<GroupResponse> toResponseList(List<Groups> students, String search) {
        List<GroupResponse> studentResponses = new ArrayList<>();
        for (Groups student : students) {
            studentResponses.add(toResponse(student, search));
        }
        return studentResponses;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public List<GroupResponse> getAll(@RequestParam(name = "search") String search) {
        if (search == null) search = "";
        List<Groups> students = groupsService.getAll(search);
        return toResponseList(students, "");
    }

    @GetMapping("/{id}")
    public GroupResponse getOne(@PathVariable int id, @RequestParam(name = "search") String search) {
        if (search == null) search = "";
        return toResponse(groupsService.getOne(id), search);
    }

    @GetMapping("/teacher/{id}")
    public List<GroupResponse> getAllByTeacherId(@PathVariable int id, @RequestParam(name = "search") String search) {
        if (search == null) search = "";
        return toResponseList(groupsService.getAllByTeacherId(id), search);
    }

    @PostMapping("/add")
    public boolean add(@RequestBody Groups student) {
        return groupsService.add(student);
    }

    @PutMapping("/update/{id}")
    public boolean update(@PathVariable int id, @RequestBody Groups student) {
        student.setId(id);
        return groupsService.update(student);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable int id) {
        return groupsService.delete(id);
    }
}
