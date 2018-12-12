package com.zjw.datamgrsys.pojo;

import java.util.Date;

public class Data {
    private int id;
    private String dataname;
    private String groupname;
    private int uploadmen;
    private String memo;
    private String enclosure;
    private String ip;
    private Date createtime;
    private Date updatetime;
    private Long times;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataname() {
        return dataname;
    }

    public void setDataname(String dataname) {
        this.dataname = dataname;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public int getUploadmen() {
        return uploadmen;
    }

    public void setUploadmen(int uploadmen) {
        this.uploadmen = uploadmen;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(String enclosure) {
        this.enclosure = enclosure;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Long getTimes() {
        return times;
    }

    public void setTimes(Long times) {
        this.times = times;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", dataname='" + dataname + '\'' +
                ", groupname='" + groupname + '\'' +
                ", uploadmen='" + uploadmen + '\'' +
                ", memo='" + memo + '\'' +
                ", enclosure='" + enclosure + '\'' +
                ", ip='" + ip + '\'' +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", times=" + times +
                '}';
    }
}
