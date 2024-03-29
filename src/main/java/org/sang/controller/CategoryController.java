package org.sang.controller;

import org.sang.bean.Category;
import org.sang.bean.RespBean;
import org.sang.service.CategoryService;
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
@RequestMapping("/admin/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    //增
        //添加单个类别 POST：/admin/category/
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public RespBean addNewCate(Category category) {
        int result = categoryService.addCategory(category);
        if (result == 1) {
            return new RespBean("success", "添加成功!");
        }
        return new RespBean("error", "添加失败!");
    }
    //删
        //删除单个类别 DELETE：/admin/category/{ids}
    @RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
    public RespBean deleteById(@PathVariable String ids) {
        boolean result = categoryService.deleteCategoryByIds(ids);
        if (result) {
            return new RespBean("success", "删除成功!");
        }
        return new RespBean("error", "删除失败!");
    }

    //改
        //修改类别 PUT：/admin/category
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public RespBean updateCate(Category category) {
        int i = categoryService.updateCategoryById(category);
        if (i == 1) {
            return new RespBean("success", "修改成功!");
        }
        return new RespBean("error", "修改失败!");
    }

    //查
        //获取所有类别 /admin/category/all
    @RequestMapping(value = "/pid", method = RequestMethod.GET)
    public int getPid(Long id) {
        return categoryService.getPid(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }
    @RequestMapping(value = "/allfirst", method = RequestMethod.GET)
    public List<Category> getAllFirstCategories() {
        return categoryService.getAllFirstCategories();
    }

    @RequestMapping(value = "/allsecond", method = RequestMethod.GET)
    public List<Category> getAllSecondCategories(Long pid) {
        return categoryService.getAllSecondCategories(pid);
    }
}
