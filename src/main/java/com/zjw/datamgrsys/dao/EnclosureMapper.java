package com.zjw.datamgrsys.dao;

import com.zjw.datamgrsys.pojo.Enclosure;

import java.util.List;

public interface EnclosureMapper {
    int insert(Enclosure enclosure);
    List<Enclosure> findByDataId(Integer dataId);
    void delByDataId(Integer dataId);
}
