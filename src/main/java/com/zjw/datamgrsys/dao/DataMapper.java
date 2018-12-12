package com.zjw.datamgrsys.dao;

import com.zjw.datamgrsys.pojo.Data;

import java.util.List;

public interface DataMapper {
    Data findDataById(int id);
    List<Data>  findAllData();
    List<Data> findDataByName(String name);
    List<Data> findDataByGroupName(String groupname);
    Data findByData(Data data);
    int insert(Data data);
    int update(Data data);
    void delById(Integer id);
}
