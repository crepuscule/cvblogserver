package org.sang.bean;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sang on 2017/12/20.
 */
public class Article {
    private Long id;
    private String title;
    private String mdContent;   //makedownn内容
    private String htmlContent; //html内容
    private String summary; //摘要
    private Long cid; //类别id=》将来多个类别，只记录最小层级的id，根据并查集递归找到最大类别
    private Long pid; //类别id=》将来多个类别，只记录最小层级的id，根据并查集递归找到最大类别
    private Long uid; //创建的用户id
    private Timestamp publishTime; //发布时间
    private Integer state; //当前状态
    private Integer pageView; //浏览量
    private Timestamp editTime; //最后编辑时间
    private String[] dynamicTags; //动态标签
    private String nickName; //昵称？
    private String cateName; //类别名？？
    private List<Tags> tags; //标签列表？？
    private String stateStr; //状态字符串？？

    public String getStateStr() {
        return stateStr;
    }

    public void setStateStr(String stateStr) {
        this.stateStr = stateStr;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String[] getDynamicTags() {
        return dynamicTags;
    }

    public void setDynamicTags(String[] dynamicTags) {
        this.dynamicTags = dynamicTags;
    }

    public Timestamp getEditTime() {
        return editTime;
    }

    public void setEditTime(Timestamp editTime) {
        this.editTime = editTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMdContent() {
        return mdContent;
    }

    public void setMdContent(String mdContent) {
        this.mdContent = mdContent;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Timestamp getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Timestamp publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getPageView() {
        return pageView;
    }

    public void setPageView(Integer pageView) {
        this.pageView = pageView;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", mdContent='" + mdContent + '\'' +
                ", htmlContent='" + htmlContent + '\'' +
                ", summary='" + summary + '\'' +
                ", cid=" + cid +
                ", uid=" + uid +
                ", publishTime=" + publishTime +
                ", state=" + state +
                ", pageView=" + pageView +
                ", editTime=" + editTime +
                ", dynamicTags=" + Arrays.toString(dynamicTags) +
                ", nickname='" + nickName + '\'' +
                ", cateName='" + cateName + '\'' +
                ", tags=" + tags +
                ", stateStr='" + stateStr + '\'' +
                '}';
    }
}
