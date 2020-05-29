package com.gsk;

/**
 * @description: TODO
 * @date: 2020/5/29 17:12
 * @author: ShangKun
 * @version: 2.0.0
 */
public class Regexp {

    public static void main(String[] args) {
        String phone = "18501234234";

        String hidenPhone = phone.replaceAll("(\\d{3})(\\d{4})(\\d{4})", "$0 $1 $2 $3");

        System.out.println(hidenPhone);
    }
}
