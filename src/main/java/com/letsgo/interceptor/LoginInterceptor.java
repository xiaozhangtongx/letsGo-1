package com.letsgo.interceptor;


import com.letsgo.lang.CommonConstant;
import com.letsgo.pojo.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    return  true;
//    HttpSession session = request.getSession();
//    SysUser user = (SysUser) session.getAttribute("userInfo");
//    Cookie[] cookies = request.getCookies();
//    SysUser user = null;
//    for (Cookie cookie: cookies) {
//      if(cookie.getName() == "ticket"){
//        user = (SysUser) redisTemplate.opsForValue().get(cookie.getValue());
//        redisTemplate.opsForValue().set(cookie.getName(),cookie.getValue());
//        break;
//      }
//    }
//    if (user == null) {
//      System.out.println("未登录");
//      response.sendError(CommonConstant.SC_NO_LOGIN, "登录失效，请重新登录");
//      return false;
//    } else {
//      log.info("拦截日志" + user.getEmployId());
//      return true;
//    }
//  }
  }
}
