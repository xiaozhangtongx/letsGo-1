package com.letsgo.Aspect;

import com.letsgo.lang.Result;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@Slf4j
//public class DictAspect {;
//
//  @Pointcut("execution(* com.letsgo.controller.*.*(..))")
//  public void controller() { }
//
//  @Around("controller()")
//  public Object addDict(ProceedingJoinPoint joinPoint){
//      log.info("{}下的{}方法的返回值被翻译",joinPoint.getSignature().getDeclaringTypeName(),joinPoint.getSignature().getName());
//    try {
//      Object result = joinPoint.proceed();
//      // 翻译
//    } catch (Throwable throwable) {
//      throwable.printStackTrace();
//    }
//  }

//  private Object translate(Object result){
//    if(!(result instanceof Result)){
//      return result;
//    }
//    else {
//      doTranslate(((Result) result).getResult());
//      return result;
//    }
//  }

//  private Object doTranslate(Object result){
//    if(result instanceof List){
//      for (Object item : (List)result) {
//        Field[] fields = getAllFields(item);
//        for (Field field : fields) {
//
//
//        }
//
//
//      }
//    }
//  }

//  private Field[] getAllFields(Object object) {
//    Class<?> clazz = object.getClass();
//    List<Field> fieldList = new ArrayList<>();
//    while (clazz != null) {
//      fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
//      clazz = clazz.getSuperclass();
//    }
//    Field[] fields = new Field[fieldList.size()];
//    fieldList.toArray(fields);
//    return fields;
//  }
//
//  private boolean isEmpty(Object object) {
//    if (object == null) {
//      return (true);
//    }
//    if ("".equals(object)) {
//      return (true);
//    }
//    if ("null".equals(object)) {
//      return (true);
//    }
//    return (false);
//  }
//
//}
