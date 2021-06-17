package kz.school.School;

import kz.school.School.models.Students;
import kz.school.School.services.StudentsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.time.LocalDate;

@Test
@ContextConfiguration(locations = { "classpath:spring-test-config.xml" })
public class MyTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private StudentsService studentsService;

    @Autowired
    private StudentTestMapper studentsMapper;

    @Test
    public void test(){
        Students student = new Students(
                0,
                "Test",
                "Student",
                Date.valueOf(LocalDate.now()),
                1
        );
        studentsService.add(student);
        Students added_student = studentsMapper.getLast();
        assertThat(added_student.getName()).isEqualTo(student.getName());
        assertThat(added_student.getSurname()).isEqualTo(student.getSurname());
        assertThat(added_student.getBdate()).isEqualTo(student.getBdate());
    }

}
