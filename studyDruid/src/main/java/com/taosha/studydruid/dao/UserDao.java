package com.taosha.studydruid.dao;

import com.taosha.studydruid.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description :
 * @Author : zhangmin
 * @Data 2019-08-21 5:49 PM
 **/
@Mapper
public interface UserDao {
    int addUser(User user);

    int deleteUserById(Long id);

    int updateUserById(User user);

    User queryUserById(Long id);

    List<User> queryUserList();
}
