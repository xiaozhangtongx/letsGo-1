package com.letsgo.service;

import com.letsgo.pojo.SysUserRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 使命必达
 * @since 2021-12-21
 */
public interface SysUserRoleService extends IService<SysUserRole> {


  List<String> getRoleDictListById(int id);

  List<Integer> getRoleIdListById(int id);

  public boolean updateRoleByUserId(List<SysUserRole> list);

}
