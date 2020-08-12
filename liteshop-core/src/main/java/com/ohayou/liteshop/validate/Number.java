package com.ohayou.liteshop.validate;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author liyan
 * @date 2020/8/2 下午3:38
 */
@Target({ElementType.FIELD,ElementType.CONSTRUCTOR,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NumberValidator.class)
public @interface Number {
    String regexp() default "";
    String message() default "必须为数字";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
