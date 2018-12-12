package com.zjw.datamgrsys.service;

import com.zjw.datamgrsys.pojo.Data;
import com.zjw.datamgrsys.util.MgrResult;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface DataService {

    MgrResult uploadData(Data data);

    MgrResult getData(Integer queryType, String condition);

    MgrResult upload(@RequestParam("file") MultipartFile[] files, Data data,String realPath);

    MgrResult delData(Integer id,String realPath);

    MgrResult getEnclosure(Integer dataid,String basePath);
}
