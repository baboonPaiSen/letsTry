package com.gsk.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @description: TODO
 * @date: 2020/6/17 19:41
 * @author: ShangKun
 * @version: 2.0.0
 */

@Data
@NoArgsConstructor
public class ElasticSearchTestUser {

    private  String name;

    private  Integer age;

    private  Date    birthday;

    private List<String>  favorites;
}
