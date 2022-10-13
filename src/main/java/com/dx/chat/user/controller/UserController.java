package com.dx.chat.user.controller;

import com.dx.chat.user.entity.User;
import com.dx.chat.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author rockstarsteven
 * @since 2022-10-13
 */
@RestController
@RequestMapping("/user/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/getInfo")
    public Object getInfo() {
        List<User> list = userService.lambdaQuery().isNotNull(User::getId).list();
        Map map = new HashMap();
        map.put("name", "tom");
        map.put("userList",list);
        return map;
    }

}
