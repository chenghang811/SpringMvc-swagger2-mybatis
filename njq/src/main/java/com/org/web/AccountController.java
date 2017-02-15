package com.org.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.org.common.util.AuthUtil;
import com.org.entity.system.User;

/**
 * 用户
 * @author Chenghang
 *
 */
@RestController
@RequestMapping("/user")
public class AccountController {
    Logger logger = LoggerFactory.getLogger(AccountController.class);

    /**
     * login
     * @return
     */
    @RequestMapping(value = "/success", method = RequestMethod.GET)
    private String login(ModelMap model, HttpServletRequest request, HttpServletResponse respose) {
        this.logger.info("登录成功");
        User user = AuthUtil.getUser();
        model.put("user", user);
        return "sucess";
    }
}
