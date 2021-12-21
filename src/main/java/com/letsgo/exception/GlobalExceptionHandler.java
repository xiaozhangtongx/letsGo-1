package com.letsgo.exception;


import com.letsgo.lang.Result;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
//@RestControllerAdvice
@Aspect
public class GlobalExceptionHandler
{
  // 处理Exception自定义异常
	@ExceptionHandler(value = GlobalException.class)
  // 默认使用了的@ResponseBody注解,会将方法返回的Map转换为JSON数据发送给浏览器
  public Object GlobalExceptionHandler(Exception e) throws Exception
  {
    String message = e.getMessage();
    return Result.error(message);
  }

  @ExceptionHandler(value = BindException.class)
  public Result BindExceptionHandler(Exception e) throws Exception {
	  return Result.error("参数校验异常"+e.getMessage());
  }

  @ExceptionHandler(value = Exception.class)
  public Result OtherExceptionHandler(Exception e) throws Exception{
	  return Result.error(e.getMessage());
  }
}
