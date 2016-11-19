/*
 *
 * Copyright (C) 1999-2016 IFLYTEK Inc.All Rights Reserved.
 * History：
 * Version   Author      Date                              Operation
 * 1.0       yaochen4    2016/11/18                           Create
 */
package com.piggsoft.validation;

import com.piggsoft.model.User;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author yaochen4
 * @version 1.0
 * @create 2016/11/18
 * @since 1.0
 */
public class CheckEmailAndAddressValidator implements ConstraintValidator<CheckEmailAndAddress, User> {

    @Override
    public void initialize(CheckEmailAndAddress constraintAnnotation) {

    }

    @Override
    public boolean isValid(User value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        if (StringUtils.isEmpty(value.getAddress()) && StringUtils.isEmpty(value.getEmail())) {
            context.disableDefaultConstraintViolation();//禁用默认的message的值
            //重新添加错误提示语句
            context
                    .buildConstraintViolationWithTemplate("{0}两参数不能同时为空").addConstraintViolation();
            return false;
        }
        return true;
    }
}
