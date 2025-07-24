package com.maopi.usercenter.service;

import com.maopi.usercenter.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.maopi.usercenter.contant.UserConstant.ADMIN_ROLE;
import static com.maopi.usercenter.contant.UserConstant.USER_LOGIN_STATE;

/**
 * 用户服务
 *

 */
public interface UserService extends IService<User> {

    List<User> searchUsersByTags(List<String> tagNameList);

    /**
     * 用户注册
     *
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @param checkPassword 校验密码
     * @param planetCode    星球编号
     * @return 新用户 id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword, String planetCode);

    /**
     * 用户登录
     *
     * @param userAccount  用户账户
     * @param userPassword 用户密码
     * @param request
     * @return 脱敏后的用户信息
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 用户脱敏
     *
     * @param originUser
     * @return
     */
    User getSafetyUser(User originUser);


    /**
     * 用户注销
     *
     * @param request
     * @return
     */
    int userLogout(HttpServletRequest request);

    //更新用户信息
    int updateUser(User user,User loginUser);

    //获取当前用户信息
    User getLoginUser(HttpServletRequest request);

    /**
     * 是否为管理员
     *
     * @param request
     * @return
     */
     boolean isAdmin(HttpServletRequest request);

    boolean isAdmin(User loginUser);
}
