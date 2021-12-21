package com.letsgo.demo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.letsgo.lang.AliyunOSSUtil;
import com.letsgo.pojo.SysRole;
import com.letsgo.pojo.SysUser;
import com.letsgo.pojo.SysUserRole;
import com.letsgo.service.SysRoleService;
import com.letsgo.service.SysUserRoleService;
import com.letsgo.service.SysUserService;
import org.apache.http.entity.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


@SpringBootTest
class DemoApplicationTests {

  @Autowired
  SysUserService sysUserService;

  @Autowired
  SysUserRoleService sysUserRoleService;

  @Autowired
  SysRoleService sysRoleService;

  @Test
  void contextLoads() {
  }

  @Test
  void UserTest(){
//    SysRole role = new SysRole().setRoleDict("普通用户");
//    sysRoleService.save(role);
//    SysUser sysUser = new SysUser().setNickname("普通测试用户01")
//            .setUsername("123456")
//            .setPassword("123456")
//            .setStateKey(0);
//    sysUserService.save(sysUser);

//    SysUserRole sysUserRole = new SysUserRole().setRoleId(1)
//            .setUserId(1);
//    sysUserRoleService.save(sysUserRole);
    Page<SysUser> iPage = new Page(1, 10);
    SysUser sysUser = new SysUser();
    System.out.println( sysUserService.myPageSelectList(iPage,sysUser));
  }

  @Autowired
  AliyunOSSUtil aliyunOSSUtil;
  @Test
  void OSSTest() throws IOException {
    File file = new File("src/main/resources/static/test.txt");
    FileInputStream fileInputStream = new FileInputStream(file);
    MultipartFile multipartFile = new MockMultipartFile("copy"+file.getName(),file.getName(),
            ContentType.APPLICATION_OCTET_STREAM.toString(),fileInputStream);
    System.out.println(aliyunOSSUtil.upload(multipartFile,multipartFile.getName()));
  }

}
