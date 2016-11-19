/*
 *
 * Copyright (C) 1999-2016 IFLYTEK Inc.All Rights Reserved.
 * History：
 * Version   Author      Date                              Operation
 * 1.0       yaochen4    2016/11/18                           Create
 */
package com.piggsoft.config;

import com.piggsoft.validation.ParamErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Locale;

/**
 * @author yaochen4
 * @version 1.0
 * @create 2016/11/18
 * @since 1.0
 */
@ControllerAdvice
public class ExceptionConfiguration {

    private static final int DEFAULT_PARAM_ERROR_CODE = 1101;
    private static final String PARAM_ERROR_CODE_SPILT_MESSAGE = "::";

    @Autowired
    private ReloadableResourceBundleMessageSource resourceBundleMessageSource;

    public String getMessage(MessageSourceResolvable resolvable) {
        return resourceBundleMessageSource.getMessage(resolvable, Locale.SIMPLIFIED_CHINESE);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handleParamError(Exception e) {
        System.out.println(e);
        return null;
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Object handleParamError(BindException e) {
        List<ObjectError> errors = e.getAllErrors();
        if (errors == null || errors.size() < 1) {
            //TODO
            return null;
        }
        ObjectError error = errors.get(0);
        return create(error);
    }

    private ParamErrorResponse create(ObjectError error) {
        ParamErrorResponse response = new ParamErrorResponse();
        String message = getMessage(error);
        String[] splits = message.split(PARAM_ERROR_CODE_SPILT_MESSAGE);
        if (splits.length > 1) {
            response.setCode(Integer.parseInt(splits[0]));
            response.setMessage(splits[1]);
        } else {
            response.setCode(DEFAULT_PARAM_ERROR_CODE);
            response.setMessage(splits[0]);
        }
        Object[] arguments = error.getArguments();
        if (arguments.length > 0) {
            DefaultMessageSourceResolvable resolvable = (DefaultMessageSourceResolvable) arguments[0];
            response.setField(getMessage(resolvable));
        }
        return response;
    }

}
