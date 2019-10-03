package org.sang.service;

import org.sang.bean.Tag;
import org.sang.mapper.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by sang on 2017/12/19.
 */
@Service
@Transactional
public class TagService {
    @Autowired
    TagMapper tagMapper;
    // 增
    public int addTag(Tag tag) {
        tag.setCreateTime(new Timestamp(System.currentTimeMillis()));
        return tagMapper.addTag(tag);
    }
    //删 可批量删
    public boolean deleteTagByIds(String ids) {
        String[] split = ids.split(",");
        int result = tagMapper.deleteTagByIds(split);
        return result == split.length;
    }
    //改
    public int updateTagById(Tag tag) {
        return tagMapper.updateTagById(tag);
    }
    //查
    public List<Tag> getAllTags() {
        return tagMapper.getAllTags();
    }
}
