package com.gsk.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @description: TODO
 * @date: 2020/6/22 20:49
 * @author: ShangKun
 * @version: 2.0.0
 */
@Data
@ToString
@NoArgsConstructor
public class Content {
    private String image;
    private String name;
    private String price;
    private String shop;
}
