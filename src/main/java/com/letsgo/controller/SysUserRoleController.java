package com.letsgo.controller;


import com.letsgo.lang.Result;
import com.letsgo.pojo.SysUserRole;
import com.letsgo.service.SysRoleService;
import com.letsgo.service.SysUserRoleService;
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
@RequestMapping("/letsgo/sys-user-role")
public class SysUserRoleController {
  @Autowired
  SysUserRoleService sysUserRoleService;

  @Autowired
  SysRoleService sysRoleService;

  @GetMapping(value = "/list")
  public Result list(){
    return Result.OK(sysUserRoleService.list());
  }

  @PutMapping(value = "add")
  public Result add(@RequestBody SysUserRole sysUserRole){
    sysUserRoleService.save(sysUserRole);
    return Result.OK("添加成功");
  }

  @PostMapping(value = "edit")
  public Result edit(@RequestBody List<SysUserRole> roleList){
    if(sysUserRoleService.updateRoleByUserId(roleList)){
      return Result.OK("修改成功");
    }
    else {
      return Result.error("请至少选择一个角色！");
    }
  }

  @DeleteMapping(value = "delete")
  public Result delete(@RequestBody SysUserRole sysUserRole){
    sysUserRoleService.removeById(sysUserRole.getId());
    return Result.OK("删除成功");
  }
}

