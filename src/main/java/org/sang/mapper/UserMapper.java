package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.Role;
import org.sang.bean.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by sang on 2017/12/17.
 */
@Mapper
@Component(value ="UserMapper")
public interface UserMapper {
    //[增]
    long reg(User user);
        //给用户设立角色
    int setUserRoles(@Param("rids") Long[] rids, @Param("id") Long id);
    //[删]
    int deleteUserById(Long uid);
        //删除某个角色的用户?
    int deleteUserRolesByUid(Long id);
    //[改]
        //更新邮件
    int updateUserEmail(@Param("email") String email, @Param("id") Long id);
        //更新启动与否
    int updateUserEnabled(@Param("enabled") Boolean enabled, @Param("uid") Long uid);
    //[查]
    User getUserById(@Param("id") Long id);
        //通过户用户名查询
    User loadUserByUsername(@Param("userName") String userName);
        //通过昵称查询
    List<User> getUserByNickname(@Param("nickname") String nickName);
        //获取所有角色
    List<Role> getAllRole();
}
