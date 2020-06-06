package com.gsk.pojo;

import lombok.Data;

import java.util.List;

/**
 * @description: TODO
 * @date: 2020/6/4 20:36
 * @author: ShangKun
 * @version: 2.0.0
 */
@Data
public class School {

    private String schoolName;

    private List<Class> classes;
}
