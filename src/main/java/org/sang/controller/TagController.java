package org.sang.controller;

import org.sang.bean.Tag;
import org.sang.bean.RespBean;
import org.sang.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 超级管理员专属Controller
 */
@RestController
@RequestMapping("/admin/tag")
public class TagController {
    @Autowired
    TagService tagService;

    //增
        //添加单个类别 POST：/admin/tag/
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public RespBean addNewTag(Tag tag) {
        int result = tagService.addTag(tag);
        if (result == 1) {
            return new RespBean("success", "添加成功!");
        }
        return new RespBean("error", "添加失败!");
    }
    //删
        //删除单个类别 DELETE：/admin/tag/{ids}
    @RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
    public RespBean deleteById(@PathVariable String ids) {
        boolean result = tagService.deleteTagByIds(ids);
        if (result) {
            return new RespBean("success", "删除成功!");
        }
        return new RespBean("error", "删除失败!");
    }

    //改
        //修改类别 PUT：/admin/tag
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public RespBean updateTag(Tag tag) {
        int i = tagService.updateTagById(tag);
        if (i == 1) {
            return new RespBean("success", "修改成功!");
        }
        return new RespBean("error", "修改失败!");
    }

    //查
        //获取所有类别 /admin/tag/all
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Tag> getAllTags() {
        return tagService.getAllTags();
    }
}
