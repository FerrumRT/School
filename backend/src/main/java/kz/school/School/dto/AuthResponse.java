package kz.school.School.dto;

import kz.school.School.models.Teachers;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;

public class AuthResponse implements Serializable {

    private static final long serialVersionUID = 987654321L;
    private final String jwtToken;
    private final TeacherResponse teacher;

    public AuthResponse(String jwtToken, TeacherResponse teacher){
        this.jwtToken = jwtToken;
        this.teacher = teacher;
    }

    public String getJwtToken(){
        return this.jwtToken;
    }

    public TeacherResponse getTeacher(){
        return this.teacher;
    }
}
