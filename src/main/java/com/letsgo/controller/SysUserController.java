package com.letsgo.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.letsgo.exception.GlobalException;
import com.letsgo.lang.Result;
import com.letsgo.pojo.SysUser;
import com.letsgo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 使命必达
 * @since 2021-12-21
 */
@RestController
@RequestMapping("/letsgo/sys-user")
public class SysUserController {
  @Autowired
  SysUserService sysUserService;

  @GetMapping(value = "/list")
  public Result listTeacher(SysUser user,
                            @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {

    Page<SysUser> page = new Page<>(pageNo, pageSize);
    List<SysUser> list = sysUserService.myPageSelectList(page,user);
    return  Result.OK(list);
  }

  @PutMapping(value = "add")
  public Result add(@RequestBody SysUser sysUser) throws GlobalException {
      sysUserService.saveIdentity(sysUser);
      return Result.OK("添加成功");
  }

  @PostMapping(value = "edit")
  public Result edit(@RequestBody SysUser sysUser){
    sysUserService.updateById(sysUser);
    return Result.OK("修改成功" );
  }

  @DeleteMapping(value = "delete")
  public Result delete(@RequestBody SysUser sysUser){
    sysUserService.removeById(sysUser);
    return Result.OK("删除成功");
  }

}

