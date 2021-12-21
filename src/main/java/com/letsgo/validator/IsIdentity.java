package com.letsgo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { IsIdentityConstraint.class})
public @interface IsIdentity {

  boolean required() default false;

  String message() default "不符合身份证格式";

  Class<?>[] groups() default { };

  Class<? extends Payload>[] payload() default { };

}
