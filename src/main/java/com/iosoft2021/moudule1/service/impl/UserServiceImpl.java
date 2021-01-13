package com.iosoft2021.moudule1.service.impl;

import com.iosoft2021.moudule1.pojo.User;
import com.iosoft2021.moudule1.mapper.UserMapper;
import com.iosoft2021.moudule1.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author iosoft2021
 * @since 2021-01-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
