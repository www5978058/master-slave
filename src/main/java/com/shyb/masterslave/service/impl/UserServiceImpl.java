package com.shyb.masterslave.service.impl;

import com.shyb.masterslave.entity.UserOrder;
import com.shyb.masterslave.mapper.order.UserOrderMapper;
import com.shyb.masterslave.mapper.user.UserMapper;
import com.shyb.masterslave.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wzh
 * @date 2019/6/14 - 13:36
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserOrderMapper userOrderMapper;
    @Override
    @Transactional
    public void change(){
        //System.out.println(userMapper.selectByPrimaryKey(1));
        //System.out.println(userMapper.deleteByPrimaryKey(4));
        System.out.println(userMapper.selectByPrimaryKey(2));
        System.out.println(userOrderMapper.selectByPrimaryKey(1));
        System.out.println(userOrderMapper.selectByPrimaryKey(2));
    }
}
