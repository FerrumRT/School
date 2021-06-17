package kz.school.School.services.impl;

import kz.school.School.mappers.TeachersMapper;
import kz.school.School.models.Teachers;
import kz.school.School.services.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeachersServiceImpl implements TeachersService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TeachersMapper teachersMapper;

    @Override
    public List<Teachers> getAll(String search) {
        return teachersMapper.findAll(search);
    }

    @Override
    public Teachers getOne(int id) {
        return teachersMapper.findOne(id);
    }

    @Override
    public boolean add(Teachers teacher) {
        teacher.setPassword(passwordEncoder.encode(teacher.getPassword()));
        return teachersMapper.add(teacher);
    }

    @Override
    public boolean update(Teachers teacher) {
        Teachers old_teacher = teachersMapper.findOne(teacher.getId());
        if (teacher.getPassword() == null) teacher.setPassword(old_teacher.getPassword());
        else teacher.setPassword(passwordEncoder.encode(teacher.getPassword()));
        if (teacher.getName() == null) teacher.setName(old_teacher.getName());
        if (teacher.getSurname() == null) teacher.setSurname(old_teacher.getSurname());
        teacher.setEmail(old_teacher.getEmail());
        return teachersMapper.update(teacher);
    }

    @Override
    public boolean delete(int id) {
        return teachersMapper.delete(id);
    }

    @Override
    public Teachers findByEmailAndPassword(String email, String password) {
        Teachers user = teachersMapper.findOneByEmail(email);
        if (user != null) {
            if (passwordEncoder.matches(password, user.getPassword())) {
                return user;
            }
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Teachers user = teachersMapper.findOneByEmail(s);
        if (user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException("USER NOT FOUND");
        }
    }
}
