package com.gsk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @description: TODO
 * @date: 2020/6/18 21:02
 * @author: ShangKun
 * @version: 2.0.0
 */
@Controller
//https://www.bilibili.com/video/BV17a4y1x7zq?p=15
public class IndexController {

    @GetMapping({"/","/index"})
    public String index(){
        return  "index";
    }
}
