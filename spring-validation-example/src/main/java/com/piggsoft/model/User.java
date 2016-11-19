/*
 *
 * Copyright (C) 1999-2016 IFLYTEK Inc.All Rights Reserved.
 * History：
 * Version   Author      Date                              Operation
 * 1.0       yaochen4    2016/11/18                           Create
 */
package com.piggsoft.model;

import com.piggsoft.validation.CannotContainSpaces;
import com.piggsoft.validation.CheckEmailAndAddress;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.ScriptAssert;

import javax.validation.constraints.NotNull;

/**
 * @author yaochen4
 * @version 1.0
 * @create 2016/11/18
 * @since 1.0
 */
//@CheckEmailAndAddress
@ScriptAssert(script = "!(_this.email==null || _this.age==null)", lang = "javascript", alias = "_this", message = "{AddressAndAgeNotNull}")
public class User {

    @NotNull(message = "{0}不能为空")
    private Long id;
    //@NotEmpty
    private String username;
    //@CannotContainSpaces
    private String password;
    private String email;
    private String address;
    private Integer age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
