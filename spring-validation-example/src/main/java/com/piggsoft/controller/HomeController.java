/*
 *
 * Copyright (C) 1999-2016 IFLYTEK Inc.All Rights Reserved.
 * History：
 * Version   Author      Date                              Operation
 * 1.0       yaochen4    2016/11/18                           Create
 */
package com.piggsoft.controller;

import com.piggsoft.model.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.groups.Default;

/**
 * @author yaochen4
 * @version 1.0
 * @create 2016/11/18
 * @since 1.0
 */
@RestController
@RequestMapping("/home")
public class HomeController {


    @RequestMapping("/get")
    public Object get(@Validated({Default.class}) User user) {
        return user;
    }

}
