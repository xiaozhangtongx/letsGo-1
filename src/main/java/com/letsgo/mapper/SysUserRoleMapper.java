package com.letsgo.mapper;

import com.letsgo.pojo.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 使命必达
 * @since 2021-12-21
 */
@Repository
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

  List<String> getDictListById(int id);
  List<Integer> getIdListById(int id);
}
