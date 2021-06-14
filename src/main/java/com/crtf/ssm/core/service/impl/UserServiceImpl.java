package com.crtf.ssm.core.service.impl;

import com.crtf.ssm.core.dao.UserMapper;
import com.crtf.ssm.core.model.User;
import com.crtf.ssm.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author crtf
 * @version V1.0
 * @className UserServiceImpl
 * @description
 * @date 21.6.9 16:49
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User signUp(User user) {
        int insert = userMapper.insert(user);
        return insert == 1 ? userMapper.selectByPrimaryKey(insert) : null;
    }

    @Override
    public User signIn(User from) {
        if(from != null && from.getName() != null && from.getPassword() != null) {
            return userMapper.selectByNamePassword(from);
        }
        return null;
    }

    @Override
    public User update(User user) {
        if (user != null && user.getId() != null && user.getName() != null && user.getPassword() != null){
            user.setSignUp(null);
            int row = userMapper.updateByPrimaryKeySelective(user);
            if (row == 1){
                return userMapper.selectByPrimaryKey(user.getId());
            }
        }
        return null;
    }

    @Override
    public List<User> selectAllUser() {
        return userMapper.selectAll();
    }


}

