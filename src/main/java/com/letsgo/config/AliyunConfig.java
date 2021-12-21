package com.letsgo.config;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource(value = {"classpath:application.properties"})
@ConfigurationProperties(prefix = "aliyun")
@Data
public class AliyunConfig {
  private String endpoint;
  private String accessKeyId;
  private String accessKeySecret;
  private String bucketName;
  private String urlPrefix;


  @Bean
  public OSS getOSSClient() {
    return new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
  }

}
