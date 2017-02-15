package com.org.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 登录
 * @author Chenghang
 *
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    Logger logger = LoggerFactory.getLogger(LoginController.class);

    /**
     * login
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    private String login(ModelMap model, HttpServletRequest request, HttpServletResponse respose) {
        this.logger.info("进入登录！");
        return "sucess";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String fail(ModelMap model, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttrs) {
        String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
        String error = null;
        if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if (exceptionClassName != null) {
            error = "其他错误：" + exceptionClassName;
        } else {
            Subject subject = SecurityUtils.getSubject();
            if (subject.isAuthenticated()) {
                System.out.println(subject.isAuthenticated());
                return "fail";
            }
        }
        model.put("error", error);
        return "fail";
    }

}
