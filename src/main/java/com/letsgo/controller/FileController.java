package com.letsgo.controller;

import com.letsgo.lang.AliyunOSSUtil;
import com.letsgo.lang.OSSResult;
import com.letsgo.lang.Result;
import com.letsgo.pojo.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/letsgo/sys-file")
public class FileController {

  @Autowired
  AliyunOSSUtil aliyunOSSUtil;

  @PutMapping(value = "upload")
  public Result add(@RequestBody MultipartFile multipartFile){
    OSSResult ossResult = aliyunOSSUtil.upload(multipartFile, multipartFile.getName());
    return Result.OK("添加成功",ossResult);
  }
}
