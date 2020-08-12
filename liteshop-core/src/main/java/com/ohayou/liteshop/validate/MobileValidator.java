package com.ohayou.liteshop.validate;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.ohayou.liteshop.validate.MobileValidate;

public class MobileValidator implements ConstraintValidator<MobileValidate,String> {
    @Override
    public void initialize(MobileValidate constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isBlank(s)) {
            return true;
        }
        Pattern p = Pattern.compile("^((13[0-9])|(14[5,7])|(15[^4,\\D])|(17[0,1,3,6-8])|(18[0-9])|(19[8,9])|(166))[0-9]{8}$");
        Matcher matcher = p.matcher(s);
        return matcher.matches();
    }
}
