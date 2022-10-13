package com.dx.chat.user.service.impl;

import com.dx.chat.user.entity.User;
import com.dx.chat.user.mapper.UserMapper;
import com.dx.chat.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author rockstarsteven
 * @since 2022-10-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
