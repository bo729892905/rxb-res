package com.rxb.res.web.controller;

import com.rxb.res.common.util.EncryptUtil;
import com.rxb.res.entity.User;
import com.rxb.res.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * 用户controller
 * Created by rxb on 2016/1/26.
 */
@Controller
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String SESSION_USER = "currentUser";

    @Resource
    private UserService userService;

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return ModelAndView
     */
    @RequestMapping(value = "login")
    public ModelAndView login(String username, String password) {
        SecurityUtils.getSecurityManager().logout(SecurityUtils.getSubject());

        UsernamePasswordToken token = new UsernamePasswordToken(username, EncryptUtil.encryptMD5(password));
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            logger.debug("用户名或密码错误！");
            return new ModelAndView("login");
        }
        User user = userService.getUserByUsername(username);
        subject.getSession().setAttribute(SESSION_USER, user);

        logger.debug("登录成功！");
        return new ModelAndView("redirect:test.do");
    }
}
