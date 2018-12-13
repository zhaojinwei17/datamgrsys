package com.zjw.datamgrsys.service.impl;

import com.zjw.datamgrsys.dao.DataMapper;
import com.zjw.datamgrsys.dao.EnclosureMapper;
import com.zjw.datamgrsys.pojo.Data;
import com.zjw.datamgrsys.pojo.Enclosure;
import com.zjw.datamgrsys.service.DataService;
import com.zjw.datamgrsys.util.MgrResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class DataServiceImpl implements DataService {

    Lock lock=new ReentrantLock();

    @Resource
    DataMapper dataMapper;
    @Resource
    EnclosureMapper enclosureMapper;

    @Override
    public MgrResult uploadData(Data data) {
        dataMapper.insert(data);
        return MgrResult.ok();
    }

    @Override
    public MgrResult getData(Integer queryType, String condition) {
        if (queryType==null || condition==null){
            List<Data> allData = dataMapper.findAllData();
            return MgrResult.ok(allData);
        }
        List<Data> dataList=null;
        switch (queryType){
            case 1:             //按资料名称查询
                dataList= dataMapper.findDataByName(condition);
                break;
            case 2:             //按小组名称查询
                dataList=dataMapper.findDataByGroupName(condition);
                break;
        }
        return MgrResult.ok(dataList);
    }

    @Override
    public MgrResult upload(MultipartFile[] files, Data data,String realPath) {
        lock.lock();
        try {
            Data data1=dataMapper.findByData(data);
            if (data1==null){
                data.setCreatetime(new Date());
                data.setUpdatetime(new Date());
                data.setTimes(0l);
                dataMapper.insert(data);
            }else {
                data=data1;
            }
        }finally {
            lock.unlock();
        }

        if (null != files && files.length > 0) {
            //遍历并保存文件
            for (MultipartFile file : files) {
                if (file != null) {
                    //取得当前上传文件的文件名称
                    String fileName =  file.getOriginalFilename();
                    //如果名称不为“”,说明该文件存在，否则说明该文件不存在
                    //本地上传图片方式
                    System.err.println(fileName);
                    int i=(int)(Math.random()*20);
                    try {
                        String path="/upload/" +i;
                        File newFile=new File(realPath+path);
                        if (!newFile.exists()){
                            newFile.mkdirs();
                        }
                        path=path+"/"+newFile.list().length;
                        newFile=new File(realPath+path);
                        newFile.mkdirs();
                        path=path+"/"+fileName;
                        newFile=new File(realPath+path);
                        file.transferTo(newFile);
                        Enclosure enclosure=new Enclosure();
                        enclosure.setDataid(data.getId());
                        enclosure.setFilename(fileName);
                        enclosure.setFilepath(path);
                        enclosure.setFilesize(file.getSize()/1024.0/1024);
                        enclosure.setUploadtime(new Date());
                        enclosureMapper.insert(enclosure);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return MgrResult.ok("上传成功！");
        } else {
            return MgrResult.build(500,"文件为空！");
        }
    }

    @Override
    public MgrResult delData(Integer id,String realPath) {
        List<Enclosure> enclosures = enclosureMapper.findByDataId(id);
        for (Enclosure enclosure: enclosures) {
            String filepath = enclosure.getFilepath();
            File file=new File(realPath+filepath);
            file.delete();
        }
        enclosureMapper.delByDataId(id);
        dataMapper.delById(id);
        return MgrResult.ok();
    }

    @Override
    public MgrResult getEnclosure(Integer dataid,String basePath) {
        List<Enclosure> enclosures = enclosureMapper.findByDataId(dataid);
        String serverIp=null;
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            serverIp=localHost.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        for (Enclosure enclosure: enclosures) {
            enclosure.setFilepath(basePath+enclosure.getFilepath());
        }
        return MgrResult.ok(enclosures);
    }
}
