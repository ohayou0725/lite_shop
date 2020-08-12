package com.ohayou.liteshop.validate;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author liyan
 * @date 2020/8/2 下午3:39
 */
public class NumberValidator implements ConstraintValidator<Number,String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isBlank(s)) {
            return true;
        }
        Pattern p = Pattern.compile("^[0-9]*$");
        Matcher matcher = p.matcher(s);
        return matcher.matches();
    }
}
