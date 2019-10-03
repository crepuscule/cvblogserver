package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.Category;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by sang on 2017/12/19.
 */
@Mapper
@Component(value ="CategoryMapper")
public interface CategoryMapper {
    //[增]
    int addCategory(Category category);
    //[删]
    int deleteCategoryByIds(@Param("ids") String[] ids);
    //[改]
    int updateCategoryById(Category category);
    //[查]
    int getPid(Long id);
    List<Category> getAllCategories();
    List<Category> getAllFirstCategories();
    List<Category> getAllSecondCategories(@Param("pid")Long pid);
}
