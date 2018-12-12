package com.zjw.datamgrsys.controller;

import com.zjw.datamgrsys.pojo.Data;
import com.zjw.datamgrsys.service.DataService;
import com.zjw.datamgrsys.util.MgrResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/data")
public class DataController {

    @Resource
    DataService dataService;

    public MgrResult uploadData(Data data){
        return dataService.uploadData(data);
    }

    @RequestMapping("/detail")
    public MgrResult getData(Integer queryType, String condition){
        return dataService.getData(queryType,condition);
    }
    @RequestMapping("/deldata")
    public MgrResult delData(Integer id,HttpServletRequest request){
        String realPath = request.getServletContext().getRealPath("/");
        return dataService.delData(id,realPath);
    }
    @RequestMapping("/getenclosure")
    public MgrResult getEnclosure(Integer dataid,HttpServletRequest request){
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
        return dataService.getEnclosure(dataid,basePath);
    }
    @CrossOrigin
    @PostMapping("/upload")
    public MgrResult upload(@RequestParam("file") MultipartFile[] files, Data data, HttpServletRequest request) {
        String ip=request.getHeader("x-forwarded-for");
        if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){
            ip=request.getHeader("Proxy-Client-IP");
        }
        if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){
            ip=request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){
            ip=request.getHeader("X-Real-IP");
        }
        if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){
            ip=request.getRemoteAddr();
        }
        data.setIp(ip);
        String realPath = request.getServletContext().getRealPath("/");
        return dataService.upload(files,data,realPath);
    }

}