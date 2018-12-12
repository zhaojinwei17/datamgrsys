package com.zjw.datamgrsys.dao;

import com.zjw.datamgrsys.pojo.User;

public interface UserMapper {
    User findUserById(int id);
    User findUserByName(String name);
    int insert(User user);
}
