package com.zjw.datamgrsys;

import com.zjw.datamgrsys.dao.UserMapper;
import com.zjw.datamgrsys.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatamgrsysApplicationTests {


    @Resource
    UserMapper userMapper;
    @Resource
    PasswordEncoder passwordEncoder;

    @Test
    public void contextLoads() {
        User user=new User();

        userMapper.insert(user);
        System.err.println(user);
    }
    @Test
    public void contextLoads1() {
//        try {
//            User user = userMapper.findUserByName("zjw");
//            System.err.println(user);
//        }catch (MyBatisSystemException e){
//            System.out.println(e.getMessage());
//        }
//        System.out.println(passwordEncoder.encode("sewqekjdgajdgj"));
//        System.out.println(passwordEncoder.encode("skjdgajdgj"));
//        System.out.println(passwordEncoder.encode("skjdgajdgj"));


        File file=new File("/Users/zhaojinwei/Desktop/a");
        System.out.println(file.list().length);
    }

}
