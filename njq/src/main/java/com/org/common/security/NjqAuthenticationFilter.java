package com.org.common.security;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

public class NjqAuthenticationFilter extends FormAuthenticationFilter {
    
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
        String username = getUsername(request);
        String password = getPassword(request);

        boolean rememberMe = isRememberMe(request);
        String host = getHost(request);
        NjqToken token = new NjqToken(username, password, rememberMe, host);

        return token;
    }
    
  /*  protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {

        Map<String, String> queryParams = new HashMap<String, String>();
        String redirectUrl = this.getLoginUrl();
        redirectUrl = "/login";
        WebUtils.issueRedirect(request, response, redirectUrl, queryParams);
    }
    
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject,
            ServletRequest request, ServletResponse response) throws Exception {
        issueSuccessRedirect(request, response);
        return false;
    }*/
}
