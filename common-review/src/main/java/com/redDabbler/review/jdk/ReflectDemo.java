package com.redDabbler.review.jdk;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author RedDabbler
 * @create 2019-01-30 16:34
 **/
@Getter
@Setter
@ToString
@Resource
public abstract class ReflectDemo<T> {
    private T data;
    private Integer t;
    private List<T> datas;
    private Class<? extends ReflectDemo> clazz;


    // 只能由子类调用
    public Class getActualClassGenericParameter(){
       return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Class getClassGenericParameter(){
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }



}
