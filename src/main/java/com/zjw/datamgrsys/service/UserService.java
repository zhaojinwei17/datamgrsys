package com.zjw.datamgrsys.service;

import com.zjw.datamgrsys.pojo.User;
import com.zjw.datamgrsys.util.MgrResult;

public interface UserService {

    MgrResult register(User user);

    MgrResult login(User user);

}
