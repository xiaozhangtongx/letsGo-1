package com.letsgo.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.letsgo.lang.Result;
import com.letsgo.pojo.DictSub;
import com.letsgo.service.DictMainService;
import com.letsgo.service.DictSubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 使命必达
 * @since 2021-12-22
 */
@RestController
@RequestMapping("/letsgo/dict")
public class DictMainController {

  @Autowired
  DictSubService dictSubService;

  @Autowired
  DictMainService dictMainService;

  @GetMapping(value = "/list")
  public Result list(String dictCode){
    LambdaQueryWrapper<DictSub> dictSubQueryWrapper = new LambdaQueryWrapper<>();
    dictSubQueryWrapper.eq(DictSub::getMainCode,dictCode);
    return Result.OK("成功",dictSubService.list(dictSubQueryWrapper));
  }

}

