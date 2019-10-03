package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.Role;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by sang on 2017/12/17.
 */
@Mapper
@Component(value ="RolesMapper")
public interface RolesMapper {
    //[增]
    int addRoles(@Param("roles") String[] roles, @Param("uid") Long uid);
    // [查] 获取所有用户的角色
    List<Role> getRolesByUid(Long uid);
}
