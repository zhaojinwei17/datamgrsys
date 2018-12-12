package com.zjw.datamgrsys.pojo;

import java.util.Date;

public class Enclosure {
    private int id;
    private int dataid;
    private String filename;
    private String filepath;
    private Double filesize;
    private Date uploadtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDataid() {
        return dataid;
    }

    public void setDataid(int dataid) {
        this.dataid = dataid;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public Double getFilesize() {
        return filesize;
    }

    public void setFilesize(Double filesize) {
        this.filesize = filesize;
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    @Override
    public String toString() {
        return "Enclosure{" +
                "id=" + id +
                ", dataid=" + dataid +
                ", filename='" + filename + '\'' +
                ", filepath='" + filepath + '\'' +
                ", filesize=" + filesize +
                ", uploadtime=" + uploadtime +
                '}';
    }
}
