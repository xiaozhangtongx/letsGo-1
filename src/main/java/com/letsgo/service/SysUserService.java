package com.letsgo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.letsgo.exception.GlobalException;
import com.letsgo.pojo.SysUser;
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
public interface SysUserService extends IService<SysUser> {


  void saveIdentity(SysUser sysUser) throws GlobalException;
  List<SysUser> myPageSelectList(Page<SysUser> page, SysUser user);

}
