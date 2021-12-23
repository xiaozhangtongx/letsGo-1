package com.letsgo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.letsgo.lang.Result;
import com.letsgo.pojo.SysUser;
import com.letsgo.service.SysUserService;
import com.letsgo.vo.LoginModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Slf4j
public class LoginController {
  @Autowired
  SysUserService userService;

  @PostMapping("/login")
  public Result<?> login(@RequestBody LoginModel loginModel,
                         HttpServletResponse response,
                          HttpSession session) {
    String username = loginModel.getUsername();
    String password = loginModel.getPassword();
//    1.校验验证码
    log.info("用户名{}，密码{}",username,password);
//    2.校验用户名
    LambdaQueryWrapper<SysUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();
    lambdaQueryWrapper.eq(SysUser::getUsername, username);
    SysUser user = userService.getOne(lambdaQueryWrapper);
    if(!user.getPassword().equals(password)){
      return Result.error("账号或秘密错误!");
    }
    else {
      session.setAttribute("userInfo", user);
      return Result.OK("登录成功！",user);
    }
  }


  @GetMapping("/logout")
  public Result<?> logout(HttpSession session) {
    session.removeAttribute("userInfo");
    return Result.OK();
  }

}
