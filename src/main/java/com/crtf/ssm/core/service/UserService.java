package com.crtf.ssm.core.service;



import com.crtf.ssm.core.model.User;

import java.util.List;

/**
 * @author crtf
 * @version 1.0
 * @createDate 2021年6月9日 星期三 18:05
 */
public interface UserService {

    /**
     * 注册
     * @return
     */
    User signUp(User user);

    /**
     * 登录
     * @return
     */
    User signIn(User user);

    /**
     * 修改用户名或密码
     * @param user
     * @return
     */
    User update(User user);

    List<User> selectAllUser();

}
