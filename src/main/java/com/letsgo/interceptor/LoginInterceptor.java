package com.letsgo.interceptor;


import com.letsgo.lang.CommonConstant;
import com.letsgo.pojo.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j(topic = "Login")
public class LoginInterceptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    HttpSession session = request.getSession();
    SysUser user = (SysUser) session.getAttribute("userInfo");
    if (user == null) {
      log.info("拦截");
      response.sendError(CommonConstant.SC_NO_LOGIN, "登录失效，请重新登录");
      return false;
    } else {
      log.info("{}登录",user.getUsername());
      return true;
    }
  }
}
