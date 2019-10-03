package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.Article;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by sang on 2017/12/20.
 */
@Mapper
@Component(value ="ArticleMapper")
public interface ArticleMapper {
    //[增]加新文章
    int addNewArticle(Article article);

    //[删]
    int deleteArticleById(@Param("aids") Long[] aids);

    //[改]文章
    int updateArticle(Article article);
        //根据id数组批量修改文章状态
    int updateArticleState(@Param("aids") Long aids[], @Param("state") Integer state);

    //[查]根据..获得文章(数量)
    Article getArticleById(Long aid);
        //获取  指定状态，起始位置和位移，用户，关键词  的文章
    List<Article> getArticleByState(@Param("state") Integer state, @Param("start") Integer start, @Param("count") Integer count, @Param("uid") Long uid,@Param("keywords") String keywords);
        //获取 指定状态，用户，管检测 的文章数量
    int getArticleCountByState(@Param("state") Integer state, @Param("uid") Long uid, @Param("keywords") String keywords);
//    List<Article> getArticleByStateByAdmin(@Param("start") int start, @Param("count") Integer count, @Param("keywords") String keywords);

    //-----------------------------------------------------------
    //浏览量自增
    //void pvIncrement(Long aid);

    //INSERT INTO pv(countDate,pv,uid) SELECT NOW(),SUM(pageView),uid FROM article GROUP BY uid
    //每天统计浏览量数据
    //void pvStatisticsPerDay();

    //获取用户的所有类别
    //List<String> getCategories(Long uid);

    //获得用户的统计数据
    //List<Integer> getDataStatistics(Long uid);
}
