package kz.school.School.services.impl;

import kz.school.School.mappers.GroupsMapper;
import kz.school.School.models.Groups;
import kz.school.School.models.Students;
import kz.school.School.services.GroupsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupsServiceImpl implements GroupsService {

    private final GroupsMapper groupsMapper;

    public GroupsServiceImpl(GroupsMapper groupsMapper) {
        this.groupsMapper = groupsMapper;
    }

    @Override
    public List<Groups> getAll(String search) {
        search = "%" + search + "%";
        return groupsMapper.findAll(search);
    }

    @Override
    public Groups getOne(int id) {
        return groupsMapper.findOne(id);
    }

    @Override
    public boolean add(Groups group) {
        return groupsMapper.add(group);
    }

    @Override
    public boolean update(Groups group) {
        Groups old_group = groupsMapper.findOne(group.getId());
        if (group.getName() == null) group.setName(old_group.getName());
        group.setTeacher(old_group.getTeacher());
        return groupsMapper.update(group);
    }

    @Override
    public boolean delete(int id) {
        return groupsMapper.delete(id);
    }

    @Override
    public List<Groups> getAllByTeacherId(int id) {
        return groupsMapper.findAllByTeacherId(id);
    }
}
