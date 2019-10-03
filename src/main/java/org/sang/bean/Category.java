package org.sang.bean;

import java.sql.Timestamp;

/**
 * Created by sang on 2017/12/19.
 */
public class Category {
    private Long id;
    private Long pid;
    private String cateName;    //类别名称
    //>>添加
    private String description; //描述
    //<<
    private Timestamp createTime;     //创建时间

    public Category() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Category{" +
                "id=" + id +
                ", pid=" + pid +
                ", cateName='" + cateName + '\'' +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}

