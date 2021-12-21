package com.letsgo.validator;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsIdentityConstraint implements ConstraintValidator<IsIdentity,String> {
  private boolean required;
  //根据注解中的值去初始化方法中的值
  @Override
  public void initialize(IsIdentity constraintAnnotation) {
    required = constraintAnnotation.required();
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if(required){
      //使用校验方法校验
      return !StringUtils.isEmpty(value) && value.length() == 18;
    }
    else{
      if(StringUtils.isEmpty(value)){
        return true;
      }
      else {
        //使用校验方法校验
        return value.length() == 18;
      }
    }
  }
}
