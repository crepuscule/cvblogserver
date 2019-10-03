package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by sang on 2017/12/21.
 */
@Mapper
@Component(value ="TagsMapper")
public interface TagsMapper {
    //[增]
    int saveTags(@Param("tags") String[] tags);
    int saveTags2ArticleTags(@Param("tagIds") List<Long> tagIds, @Param("aid") Long aid);
    //[删]
    int deleteTagsByAid(Long aid);
    //[查]
    List<Long> getTagsIdByTagName(@Param("tagNames") String[] tagNames);
}
