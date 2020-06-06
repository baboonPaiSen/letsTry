package com.gsk.pojo;

import lombok.Data;

import java.util.List;

/**
 * @description: TODO
 * @date: 2020/6/4 20:37
 * @author: ShangKun
 * @version: 2.0.0
 */
@Data
public class Class {

    private String  className;

    private List<Student> students;
}
