package org.sang.bean;

/**
 * Created by sang on 2017/12/21.
 */
public class Tags {
    private Long id;
    private String tagName;
    private  String description; //标签描述

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

    @Override
    public String toString() {
        return "Tags{" +
                "id=" + id +
                ", tagName='" + tagName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
