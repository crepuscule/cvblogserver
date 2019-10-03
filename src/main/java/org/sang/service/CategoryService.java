package org.sang.service;

import org.sang.bean.Category;
import org.sang.mapper.CategoryMapper;
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
public class CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    // 增
    public int addCategory(Category category) {
        category.setCreateTime(new Timestamp(System.currentTimeMillis()));
        return categoryMapper.addCategory(category);
    }
    //删 可批量删
    public boolean deleteCategoryByIds(String ids) {
        String[] split = ids.split(",");
        int result = categoryMapper.deleteCategoryByIds(split);
        return result == split.length;
    }
    //改
    public int updateCategoryById(Category category) {
        return categoryMapper.updateCategoryById(category);
    }
    //查
    public int getPid(Long id){
        return categoryMapper.getPid(id);
    }
    public List<Category> getAllCategories() {
        return categoryMapper.getAllCategories();
    }
    public List<Category> getAllFirstCategories() {
        return categoryMapper.getAllFirstCategories();
    }
    public List<Category> getAllSecondCategories(Long pid) {
        return categoryMapper.getAllSecondCategories(pid);
    }
}
