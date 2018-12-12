package com.zjw.datamgrsys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.zjw.datamgrsys.dao")
public class DatamgrsysApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DatamgrsysApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 设置启动类,用于独立tomcat运行的入口
        return builder.sources(DatamgrsysApplication.class);
    }
}
