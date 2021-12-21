package com.letsgo.controller;


import com.letsgo.lang.Result;
import com.letsgo.pojo.SysRole;
import com.letsgo.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 使命必达
 * @since 2021-12-21
 */
@RestController
@RequestMapping("/letsgo/sys-role")
public class SysRoleController {
  @Autowired
  SysRoleService sysRoleService;

  @GetMapping(value = "/list")
  public Result list(){
    return Result.OK(sysRoleService.list());
  }

  @PutMapping(value = "add")
  public Result add(@RequestBody SysRole sysRole){
    sysRoleService.save(sysRole);
    return Result.OK("添加成功");
  }

  @PostMapping(value = "edit")
  public Result edit(@RequestBody SysRole sysRole){
    sysRoleService.updateById(sysRole);
    return Result.OK("修改成功" );
  }

  @DeleteMapping(value = "delete")
  public Result delete(@RequestBody SysRole sysRole){
    sysRoleService.removeById(sysRole.getId());
    return Result.OK("删除成功");
  }

}

