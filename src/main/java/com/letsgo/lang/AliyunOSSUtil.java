package com.letsgo.lang;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.DeleteObjectsRequest;
import com.aliyun.oss.model.DeleteObjectsResult;
import com.aliyun.oss.model.GeneratePresignedUrlRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.List;

@Component
public class AliyunOSSUtil {

  @Value("${aliyun.endpoint}")
  private String endpoint;
  @Value("${aliyun.accessKeyId}")
  private String accessKeyId;
  @Value("${aliyun.accessKeySecret}")
  private String accessKeySecret;
  @Value("${aliyun.bucketName}")
  private String bucketName;
  @Value("${aliyun.urlPrefix}")
  private String urlPrefix;

  @Autowired
  OSS ossClient;
  /**
   * 上传文件，以IO流方式
   *
   * @param objectName      唯一objectName（在oss中的文件名字）
   */
  public OSSResult upload(MultipartFile file, String objectName) {
   OSSResult aliyunOssResult = new OSSResult();
    try {

      ossClient.putObject(bucketName, objectName, file.getInputStream());
      // 关闭OSSClient。
      ossClient.shutdown();
      aliyunOssResult.setCode(200);
      aliyunOssResult.setUrl(urlPrefix+objectName);
      aliyunOssResult.setMsg("上传成功");
    } catch (Exception e) {
      e.printStackTrace();
      aliyunOssResult.setCode(400);
      aliyunOssResult.setMsg("上传失败");
    }
    return aliyunOssResult;
  }

  /**
   * 删除OSS中的单个文件
   *
   * @param objectName 唯一objectName（在oss中的文件名字）
   */
  public void delete(String objectName) {
    try {
      // 删除文件。
      ossClient.deleteObject(bucketName, objectName);
      // 关闭OSSClient。
      ossClient.shutdown();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 批量删除OSS中的文件
   *
   * @param objectNames oss中文件名list
   */
  public void delete(List<String> objectNames) {
    try {
      // 批量删除文件。
      DeleteObjectsResult deleteObjectsResult = ossClient.deleteObjects(new DeleteObjectsRequest(bucketName).withKeys(objectNames));
      List<String> deletedObjects = deleteObjectsResult.getDeletedObjects();
      // 关闭OSSClient。
      ossClient.shutdown();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 获取文件临时url
   *
   * @param objectName oss中的文件名
   * @param effectiveTime 有效时间(ms)
   */
  public String getUrl(String objectName,long effectiveTime){
    // 设置URL过期时间
    Date expiration = new Date(new Date().getTime() + effectiveTime);
    GeneratePresignedUrlRequest generatePresignedUrlRequest ;
    generatePresignedUrlRequest =new GeneratePresignedUrlRequest(bucketName, objectName);
    generatePresignedUrlRequest.setExpiration(expiration);
    URL url = ossClient.generatePresignedUrl(generatePresignedUrlRequest);
    return url.toString();
  }

}

