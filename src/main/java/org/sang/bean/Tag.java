package org.sang.bean;

import java.sql.Timestamp;
/**
 * Created by sang on 2017/12/21.
 */
public class Tag {
    private Long id;
    private String tagName;
    private  String description; //标签描述
    private Timestamp createTime;     //创建时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", tagName='" + tagName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
