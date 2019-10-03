package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.Tag;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by sang on 2017/12/19.
 */
@Mapper
@Component(value ="TagMapper")
public interface TagMapper {
    //[增]
    int addTag(Tag tag);
    //[删]
    int deleteTagByIds(@Param("ids") String[] ids);
    //[改]
    int updateTagById(Tag tag);
    //[查]
    int getPid(Long id);
    List<Tag> getAllTags();
}
