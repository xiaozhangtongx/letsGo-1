package com.letsgo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.letsgo.pojo.SysUserRole;
import com.letsgo.mapper.SysUserRoleMapper;
import com.letsgo.service.SysUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 使命必达
 * @since 2021-12-21
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {

  @Autowired
  SysUserRoleMapper sysUserRoleMapper;
  @Override
  public List<String> getRoleDictListById(int id) {
    return sysUserRoleMapper.getDictListById(id);
  }

  @Override
  public List<Integer> getRoleIdListById(int id) {
    return sysUserRoleMapper.getIdListById(id);
  }

  @Override
  public boolean updateRoleByUserId(List<SysUserRole> list) {
    if(list.size() <= 0){
      return  false;
    }
    int userId = list.get(0).getUserId();
    LambdaQueryWrapper<SysUserRole> sysUserRoleQueryWrapper = new  LambdaQueryWrapper<>();
    sysUserRoleQueryWrapper.eq(SysUserRole::getUserId, userId);
    remove(sysUserRoleQueryWrapper);
    saveBatch(list);
    return true;
  }
}
