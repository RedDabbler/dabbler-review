package com.redDabbler.review.swagger.model;

import io.swagger.annotations.ApiModelProperty;

public class User {

    // 指定 实体的注释
    @ApiModelProperty(notes = "用户id")
    private Long id;
    @ApiModelProperty(notes = "用户姓名")
    private String name;
    @ApiModelProperty(notes = "用户年龄")
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
