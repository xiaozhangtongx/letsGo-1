package com.letsgo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.letsgo.exception.GlobalException;
import com.letsgo.pojo.SysUser;
import com.letsgo.mapper.SysUserMapper;
import com.letsgo.service.SysUserRoleService;
import com.letsgo.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.SneakyThrows;
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
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

  @Autowired
  SysUserMapper sysUserMapper;
  @Autowired
  SysUserRoleService sysUserRoleService;
  @Override
  public List<SysUser> myPageSelectList(Page<SysUser> page, SysUser user) {
    QueryWrapper<SysUser> wrapper = new QueryWrapper<>(user);
    IPage<SysUser> iPage = sysUserMapper.selectPage(page,wrapper);
    List<SysUser> list = iPage.getRecords();
    list.forEach((item)->{
      item.setRoles_dict(sysUserRoleService.getRoleDictListById(item.getId()));
      item.setRoles(sysUserRoleService.getRoleIdListById(item.getId()));
    });
    return list;
  }

  @SneakyThrows
  @Override
  public SysUser getOne(Wrapper<SysUser> queryWrapper) {
    SysUser res = super.getOne(queryWrapper);
    if(res == null){
      throw new GlobalException("不存在该用户！");
    }
    res.setRoles(sysUserRoleService.getRoleIdListById(res.getId()));
    res.setRoles_dict(sysUserRoleService.getRoleDictListById(res.getId()));
    return this.getOne(queryWrapper, true);
  }

  @Override
  public void saveIdentity(SysUser sysUser) throws GlobalException {
    if( !checkIdentity(sysUser)){
      throw new GlobalException("该账号已被使用！");
    }
    else {
      save(sysUser);

    }
  }

  private boolean checkIdentity(SysUser sysUser) {
    LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<SysUser>();
    wrapper.or().eq(SysUser::getUsername,sysUser.getUsername());
    if( list(wrapper).size() > 0){
      return false;
    }
    else {
      save(sysUser);
      return true;
    }
  }
}
