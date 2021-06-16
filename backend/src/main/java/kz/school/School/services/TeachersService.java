package kz.school.School.services;

import kz.school.School.models.Teachers;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface TeachersService extends UserDetailsService {
    List<Teachers> getAll();
    Teachers getOne(int id);
    boolean add(Teachers teacher);
    boolean update(Teachers teacher);
    boolean delete(int id);

    Teachers findByEmailAndPassword(String email, String password);
}
