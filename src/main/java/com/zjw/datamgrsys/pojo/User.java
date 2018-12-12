package com.zjw.datamgrsys.pojo;

import java.util.Date;

public class User {
    private int id;
    private String name;
    private String password;
    private String classes;
    private String phone;
    private String groupname;
    private int roleid;
    private int cremen;
    private Date createtime;
    private int updatemen;
    private Date updatetime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public int getCremen() {
        return cremen;
    }

    public void setCremen(int cremen) {
        this.cremen = cremen;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public int getUpdatemen() {
        return updatemen;
    }

    public void setUpdatemen(int updatemen) {
        this.updatemen = updatemen;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", classes='" + classes + '\'' +
                ", phone='" + phone + '\'' +
                ", groupname='" + groupname + '\'' +
                ", roleid=" + roleid +
                ", cremen=" + cremen +
                ", createtime=" + createtime +
                ", updatemen=" + updatemen +
                ", updatetime=" + updatetime +
                '}';
    }
}
