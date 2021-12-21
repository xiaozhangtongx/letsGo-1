package com.letsgo.lang;

import lombok.Data;

@Data
public class OSSResult {
  /**
   * code：200成功
   * code: 400失败
   */
  private int code;

  /**
   * 上传成功的返回url
   */
  private String url;

  /**
   * 提示信息
   */
  private String msg;
}
