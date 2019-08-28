package com.taosha.studydruid.controller;

import com.taosha.studydruid.dao.ScoreMapper;
import com.taosha.studydruid.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description :
 * @Author : zhangmin
 * @Data 2019-08-13 2:05 PM
 **/
@RestController
@RequestMapping(value = "/druidController")
public class DruidController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    ScoreMapper scoreMapper;

    @GetMapping("/get")
    public Object getPeople(){
        return userMapper.queryUserList();
    }

    @GetMapping("/getScore")
    public Object getScore(){
        return scoreMapper.selectByPrimaryKey(1L);
    }
}
